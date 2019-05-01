package developerwang.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

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
		ExecutorService exec = Executors.newFixedThreadPool(20);
		SemapDemo dem = new SemapDemo();
		for(int i=0;i<20;i++){
			exec.submit(dem);
		}
		
		
	}

}
