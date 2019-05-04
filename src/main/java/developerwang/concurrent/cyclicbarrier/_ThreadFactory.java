package developerwang.concurrent.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _ThreadFactory  implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		
		_ThreadFactory task =  new _ThreadFactory();
		ExecutorService es = new ThreadPoolExecutor(
				5, 
				5, 
				0L,
				TimeUnit.MILLISECONDS,
				new SynchronousQueue<Runnable>(), 
				new ThreadFactory() {  // 创建线程的参数
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						t.setName("demax"+t.getId());
						System.out.println("create "+t);
						return t;
					}
				});
		for(int i=0;i<5;i++){
			es.submit(task);
		}
		TimeUnit.SECONDS.sleep(2);
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis()+":ThreadId:"+Thread.currentThread().getId()+";name:"+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
