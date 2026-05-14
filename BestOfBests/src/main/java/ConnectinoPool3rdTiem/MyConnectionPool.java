package ConnectinoPool3rdTiem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyConnectionPool implements IConnection {

	private static volatile MyConnectionPool INSTANCE;
	private final BlockingQueue<Connection> que;
	private final AtomicInteger connectionCount;
	private final List<Connection> realConnection;
	private final int maxConnection;
	private volatile boolean isShutdown;

	private MyConnectionPool(int initalConnections, int maxConnection) {
		this.que = new LinkedBlockingQueue<>(maxConnection);
		this.maxConnection = maxConnection;
		this.connectionCount = new AtomicInteger(initalConnections);
		this.realConnection = new CopyOnWriteArrayList<>();
		this.isShutdown = false;

		System.out.println("Creating: " + initalConnections + " initial connections.");
		for (int i = 0; i < initalConnections; i++) {
			que.offer(createConnection());
		}

		System.out.println("New Connection created !! , Total Connection count is : " + initalConnections);
	}

	public static MyConnectionPool getInstance(int initalConnections, int maxConnection) {
		if (INSTANCE == null) {
			synchronized (MyConnectionPool.class) {
				if (INSTANCE == null) {
					INSTANCE = new MyConnectionPool(initalConnections, maxConnection);
				}
			}
		}

		return INSTANCE;
	}

	private Connection createConnection() {
		if (isShutdown) {
			System.out.println("Illegal error: shutdown is initiated, cannot create connection");
		}
		Connection realConnection = null; // Generate it as need
		CustomProxyConnection proxy = new CustomProxyConnection(this, realConnection);
		Connection proxyWrappedConnection = proxy.getProxyConnection();
		// Keep a lookup for real connection needed for closing
		this.realConnection.add(realConnection);
		return proxyWrappedConnection;
	}

	@Override
	public Connection getConnection() throws Exception {
		if (isShutdown) {
			System.out.println("Illegal error: shutdown is initiated, cannot fetch connection");
			return null;
		}

		Connection conn = que.poll();
		if (conn == null) {
			if (connectionCount.incrementAndGet() <= maxConnection) {
				System.out.println("Pool empty. Creating new connection...");
				System.out.println("New Connection created !! , Total Connection count is : " + connectionCount.get());
				return createConnection();
			} else {
				connectionCount.decrementAndGet();
				// incrementAndGet = check(increase and then create) ..help avoid
				// race condition if 2 threads reach here and we have only 1 capacity
			}

			// 3. If we are at maxSize, we MUST wait for someone to return a connection
			System.out.println("Max capacity reached. Waiting for a connection to be released...");
			Connection connAfterWait = que.poll(9000, TimeUnit.MILLISECONDS); // This blocks the thread safely for 5 sec
			if (connAfterWait == null) {
				System.out.println("Time-out while waiting for connection to be available.");
			}
			return connAfterWait;
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
	public void shutdown() throws SQLException {
		System.out.println("Connection Pool ShutDown Initiated");
		this.isShutdown = true;
		// Clear the pool so waiting threads stop trying to grab connections.
		que.clear();

		for (Connection conn : this.realConnection) {
			if (conn != null) {
				conn.close();
			}
		}

		this.realConnection.clear();
		this.connectionCount.set(0);
		System.out.println("Connection Pool shutdown completed.");
	}

}
