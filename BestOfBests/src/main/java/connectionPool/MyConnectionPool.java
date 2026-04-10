package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

//why you chose a BlockingQueue: it handles the "Wait/Notify" logic 
//for you automatically. If the pool is empty, 
//take() will make the thread sleep until a connection is returned.

public class MyConnectionPool implements CustomConnectionPool {
	private final String url;
	private final BlockingQueue<Connection> pool;
	private final int maxSize;
	// You need to know how many connections exist in total
	// (those in the queue + those currently being used by threads) so you don't
	// exceed maxSize
	private final AtomicInteger totalCreatedConnections = new AtomicInteger(0);
	private final List<Connection> physicalConnections = new CopyOnWriteArrayList<>();
	// The "Gatekeeper" flag
	private volatile boolean isShuttingDown = false;

	// Private constructor
	private MyConnectionPool(String url, int initialSize, int maxSize) throws Exception {
		this.url = url;
		this.maxSize = maxSize;
		this.pool = new LinkedBlockingQueue<>(maxSize);

		for (int i = 0; i < initialSize; i++) {
			pool.add(createNewConnection());
		}
	}

	// Static inner class (The Holder)
	private static class Holder {
		private static MyConnectionPool INSTANCE;
		private static Exception initializationException;

		static {
			try {
				// In a real app, these values would come from a config file
				INSTANCE = new MyConnectionPool("jdbc:h2:mem:test", 2, 5);
			} catch (Exception e) {
				initializationException = e;
			}
		}
	}

	// Public accessor
	public static MyConnectionPool getInstance() throws Exception {
		if (Holder.initializationException != null) {
			throw Holder.initializationException;
		}
		return Holder.INSTANCE;
	}

	private Connection createNewConnection() throws Exception {
		// Check if we are allowed to create new resources
		if (isShuttingDown) {
			throw new IllegalStateException("Shutdown in progress: Cannot create new connections.");
		}

		// In reality, you'd use real DB credentials here
		// Instead of DriverManager, use a Mockito mock or a simple Proxy
		// This allows you to test your POOL LOGIC without needing a DB driver
		// Connection realConn = DriverManager.getConnection(url);
		Connection mockConn = ConnectionProxy.createProxy(null, this);

		physicalConnections.add(mockConn); // Track the real one for shutdown
		// Increment our counter every time a physical connection is made
		totalCreatedConnections.incrementAndGet();
		
		// Wrap it in our Proxy so .close() doesn't break it
		//return ConnectionProxy.createProxy(mockConn, this);
		return mockConn;
	}

	@Override
	public Connection getConnection() throws Exception {
		if (isShuttingDown) {
			throw new IllegalStateException("Cannot get connection: Pool is shutting down.");
		}

		// 1. Try to get an idle connection immediately (non-blocking)
		// pool.take() is blocking
		Connection conn = pool.poll();

		if (conn == null) {
			// 2. If pool is empty, can we create a new one?
			if (totalCreatedConnections.get() < maxSize) {
				System.out.println("Pool empty. Creating new connection...");
				return createNewConnection();
			}

			// 3. If we are at maxSize, we MUST wait for someone to return a connection
			System.out.println("Max capacity reached. Waiting for a connection to be released...");
			return pool.take(); // This blocks the thread safely
		}

		return conn;
	}

	@Override
	public void releaseConnection(Connection connection) {
		if (connection != null) {
			pool.offer(connection);
		}
	}

	@Override
	// shutdown() is tricky because the pool contains Proxies, not the real
	// connections. To close the physical socket, you
	// need to unwrap them or track the real ones.
	public void shutdown() throws Exception {
		// Step 1: Flip the switch. No new connections can be born now.
		isShuttingDown = true;

		// Step 2: Clear the pool so waiting threads stop trying to grab connections.
		pool.clear();

		// Step 3: Close the physical sockets.
		// Since isShuttingDown is true, the 'physicalConnections' list is effectively
		// frozen.
		for (Connection realConn : physicalConnections) {
			if (!realConn.isClosed()) {
				realConn.close(); // Close the actual database link
			}
		}

		// Step 4: Final Cleanup
		physicalConnections.clear();
		totalCreatedConnections.set(0);
		System.out.println("Pool shutdown complete.");
	}

}
