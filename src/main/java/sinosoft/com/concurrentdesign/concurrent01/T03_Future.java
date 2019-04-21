package sinosoft.com.concurrentdesign.concurrent01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class T03_Future {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Integer> task = new FutureTask<Integer>(()->{
			TimeUnit.SECONDS.sleep(3);
			return 1000;
		});
		new Thread(task).start();
		System.out.println(task.get());
		
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> aa = service.submit(()->{
			TimeUnit.SECONDS.sleep(2);
			return 1;
		});
		System.out.println(aa.get());
		System.out.println(service);
		System.out.println(aa);
		System.out.println(aa.isDone());
		service.shutdown();
	}
}
