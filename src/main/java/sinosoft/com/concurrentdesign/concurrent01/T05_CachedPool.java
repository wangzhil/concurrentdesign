package sinosoft.com.concurrentdesign.concurrent01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T05_CachedPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		for(int i=0;i<2;i++){
			service.execute(()->{
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		System.out.println(service);
		TimeUnit.SECONDS.sleep(80);
		System.out.println(service);
	}
}
