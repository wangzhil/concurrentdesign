package developerwang.concurrent.semaphore;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemapDemo implements Runnable {

	final Semaphore semaphore = new Semaphore(5);
	@Override
	public void run() {
		try {
			semaphore.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId()+":done!");
			semaphore.release();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		SemapDemo dem = new SemapDemo();

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>(),
				r -> {
					Thread t = new Thread(r);
					t.setName("xxxxxx");
					return t;
				},new ThreadPoolExecutor.CallerRunsPolicy());
		for(int i=0;i<20;i++){
			threadPoolExecutor.submit(dem);
		}
		
		
	}

}
