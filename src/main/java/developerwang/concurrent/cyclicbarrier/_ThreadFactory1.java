package developerwang.concurrent.cyclicbarrier;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _ThreadFactory1 implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		_ThreadFactory1 task = new _ThreadFactory1();
		ExecutorService  exe = new ThreadPoolExecutor(
				5,
				5,
				0L,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>()){
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				
				System.out.println("准备执行批处理！！！");
			}
			
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				
				System.out.println("执行结束后的处理。。");
			}
			@Override
			protected void terminated() {

				System.out.println("退出批处理");
			}
			
			
		};
		for(int i=0;i<5;i++){
			
			exe.submit(task);
			Thread.sleep(10);
		}
		exe.shutdown();
		System.out.println("aaaa:"+Runtime.getRuntime().availableProcessors());
	}
	
	@Override
	public void run() {
		System.out.println("time:"+System.currentTimeMillis()+"Thread id:"+Thread.currentThread().getId()+";name:"+Thread.currentThread().getName());
	    try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	}

}
