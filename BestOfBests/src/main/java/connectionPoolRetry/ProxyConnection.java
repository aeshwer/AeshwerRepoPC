package connectionPoolRetry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ProxyConnection {

	public static Connection creatProxy(Connection realConn, ConnectionPoolService pool) {

		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("close")) {
					System.out.println("Proxy: Intercepted close(). Returning to pool...");
					pool.releaseConnection((Connection) proxy);
					return null;
				}

				if (method.getName().equals("isClosed")) {
					return false;
				}

				if (realConn == null) {
					return null;
				}

				return method.invoke(realConn, args);
			}
		};

		return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
				new Class<?>[] { Connection.class }, handler);
	}

}
