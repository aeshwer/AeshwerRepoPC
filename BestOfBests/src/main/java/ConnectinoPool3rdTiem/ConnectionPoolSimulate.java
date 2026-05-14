package ConnectinoPool3rdTiem;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolSimulate {

	public static void main(String[] args) {
		MyConnectionPool pool = MyConnectionPool.getInstance(2, 4);
		ExecutorService exService = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 5; i++) {
			int threadId = i;

			exService.execute(() -> {
				System.out.println("Thread: " + threadId + " Task is running");
				try {
					System.out.println("Thread: " + threadId + " Getting Connection");
					Connection conn = pool.getConnection();
					Thread.sleep(1000);
					if (conn == null) {
						System.out.println("Thread " + threadId + " failed to acquire connection");
						return;
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Thread: " + threadId + " Task Finished");
			});
		}

		try {
			exService.shutdown();
			exService.awaitTermination(10000, TimeUnit.MILLISECONDS);			
			pool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
