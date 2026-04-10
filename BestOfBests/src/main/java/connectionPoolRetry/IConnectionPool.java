package connectionPoolRetry;

import java.sql.Connection;

public interface IConnectionPool {

	public Connection getConnection() throws Exception;;

	public void releaseConnection(Connection conn);

	public void shutdown() throws Exception;

}
