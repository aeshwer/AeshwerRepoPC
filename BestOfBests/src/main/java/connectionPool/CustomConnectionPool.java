package connectionPool;

import java.sql.Connection;

public interface CustomConnectionPool {

	// Get a connection, blocking if none are available
	Connection getConnection() throws Exception;

	// Return connection to the pool
	void releaseConnection(Connection connection);

	// Shutdown the pool and close all physical connections
	void shutdown() throws Exception;
}
