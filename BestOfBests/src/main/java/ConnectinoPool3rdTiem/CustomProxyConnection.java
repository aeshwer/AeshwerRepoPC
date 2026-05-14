package ConnectinoPool3rdTiem;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class CustomProxyConnection {

	Connection realConnection;
	IConnection connectionPool;

	CustomProxyConnection(IConnection connectionPool, Connection realConnection) {
		this.realConnection = realConnection;
		this.connectionPool = connectionPool;
	}

	public Connection getProxyConnection() {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("close")) {
					System.out.println("Proxy: Intercepted close(). Returning to pool...");
					// DO nothing
					connectionPool.releaseConnection((Connection) proxy);
					return null;
				}

				if (method.getName().equals("isClosed")) {
					return false;
				}

				if (realConnection == null) {
					return null;
				}

				return method.invoke(realConnection, args);

			}
		};

		return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
				new Class<?>[] { Connection.class }, handler);

	}
}
