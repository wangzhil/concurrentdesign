package sinosoft.com.concurrentdesign.concurrent01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T07_ScheduledPool {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);	
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		service.scheduleAtFixedRate(()->{
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			
		}, 5, 3, TimeUnit.SECONDS);
		
	}
}
