package connectionPoolRetry;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolService implements IConnectionPool {

	private final int maxConnection;
	private final BlockingQueue<Connection> que;
	private final AtomicInteger totalConn = new AtomicInteger(0);
	private volatile boolean isShuttingDown = false;
	List<Connection> realConnections = new CopyOnWriteArrayList<>();

	private ConnectionPoolService(int initialConnection, int maxConnection) {
		this.maxConnection = maxConnection;
		this.que = new LinkedBlockingQueue<>(maxConnection);

		for (int i = 0; i < initialConnection; i++) {
			que.add(createNewConnection());
		}
	}

	private Connection createNewConnection() {
		Connection mockConn = ProxyConnection.creatProxy(null, this);
		realConnections.add(mockConn);
		totalConn.incrementAndGet();
		return mockConn;
	}

	public static ConnectionPoolService getInstance() {
		return ConnectionPoolServiceProvide.INSTANCE;
	}

	public static class ConnectionPoolServiceProvide {
		public static final ConnectionPoolService INSTANCE = new ConnectionPoolService(2, 5);
	}

	@Override
	public Connection getConnection() throws Exception {
		if (isShuttingDown) {
			throw new IllegalStateException("Cannot get connection: Pool is shutting down.");
		}

		Connection conn = que.poll();
		if (conn == null) {
			if (totalConn.get() >= maxConnection) {
				System.out.println("Max capacity reached. Waiting for a connection to be released...");
				return que.take();
			} else {
				System.out.println("Pool empty. Creating new connection...");
				return createNewConnection();
			}
		}

		return conn;
	}

	@Override
	public void releaseConnection(Connection conn) {
		if (conn != null) {
			que.offer(conn);
		}

	}

	@Override
	public void shutdown() throws Exception {
		isShuttingDown = true;
		que.clear();
		for (Connection conn : realConnections) {
			if (!conn.isClosed()) {
				conn.close();
			}
		}

		realConnections.clear();
		totalConn.set(0);
		System.out.println("Pool shutdown complete.");
	}

}
