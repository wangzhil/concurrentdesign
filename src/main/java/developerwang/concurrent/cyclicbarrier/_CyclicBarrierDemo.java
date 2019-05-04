package developerwang.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
/**
 * CyclicBarrier ��Ҫ�չ�ָ��runnable֮���ִ�ж�Ӧ��runbale������
 * @author devel
 *
 */
public class _CyclicBarrierDemo {

	public static class Solider  implements Runnable {
		
		private String solider;
		private final CyclicBarrier cyclic;
		
		public Solider(CyclicBarrier cyclic,String soliderName) {
			 this.cyclic = cyclic;
			 this.solider = soliderName;
		}
		public void run() {
			
		    try {
				cyclic.await();
				doWork();
				cyclic.await();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		void doWork(){
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(solider+":�������...");
		}
	}
	public static class BarrierRun implements Runnable{

		boolean flag;
		int N;
		public BarrierRun(Boolean flag, int N) {
			this.flag = flag;
			this.N = N;
		}
		@Override
		public void run() {
			
			if(flag){
				System.out.println("ʿ��"+N+"��������ɣ�");
			}else{
				System.out.println("ʿ��"+N+"��������ϣ�");
				this.flag =  true;
			}
		}
	}
	
	public static void main(String[] args) {
		
		final int n = 10;
		Thread[] tt = new Thread[n];
		boolean flag = false;
		CyclicBarrier cc = new CyclicBarrier(n, new BarrierRun(flag, n));
		
		System.out.println("���϶��飡");
//		for(int i=0;i<n;i++){
//			System.out.println("ʿ��:"+i+"������");
//			tt[i] = new Thread(new Solider(cc, "ʿ��"+i));
//			tt[i].start();
//		}
		for(int i=0;i<10;i++){
			new Thread(new Solider(cc, "ʿ��:"+i)).start();
		}
		
		
		
		
		
	}
}
