package developerwang.concurrent.semaphore;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _FutrueTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		return 1000;
	}
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		FutureTask<Integer> future = new FutureTask<Integer>(()->{
//			return 1000;
//		});
//		Thread t1 = new Thread(future);
//		t1.start();
//		System.out.println(future.get());
		FutureTask<Integer> task = new FutureTask<Integer>(new _FutrueTask());
		Thread t1 = new Thread(task);
		
		t1.start();
		System.out.println(task.get());
		
		
	}

	
	
	
}
