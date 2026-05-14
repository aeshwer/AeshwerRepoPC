package ConnectinoPool3rdTiem;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {

	public Connection getConnection() throws Exception;

	public void releaseConnection(Connection conn);

	public void shutdown() throws SQLException;
}
