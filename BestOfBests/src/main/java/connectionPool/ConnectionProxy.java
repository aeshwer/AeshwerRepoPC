package connectionPool;

import java.sql.Connection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * The biggest challenge is that a standard java.sql.Connection has a .close()
 * method that kills the database link. We want that method to return the 
 * connection to our pool instead.
 * */
public class ConnectionProxy {

	public static Connection createProxy(Connection realConnection, CustomConnectionPool pool) {
		// We create an instance of InvocationHandler "on the fly"
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// Intercept the "close" method call
				if (method.getName().equals("close")) {
					System.out.println("Proxy: Intercepted close(). Returning to pool...");
					// pool.releaseConnection(realConnection);
					pool.releaseConnection((Connection) proxy); // Return the PROXY itself for simulation
					return null;
				}

				// 2. Intercept isClosed() - Vital for our shutdown loop
				if (method.getName().equals("isClosed")) {
					return false; // Pretend the "mock" connection is always open
				}

				// 3. For any other method, if we have a real DB, call it.
				// If not (Simulation Mode), just return null to avoid the Crash.
				if (realConnection == null) {
					return null;
				}

				// For any other method (like executeQuery), just pass it to the real connection
				return method.invoke(realConnection, args);
			}
		};

		return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
				new Class<?>[] { Connection.class }, handler);
	}
}
