package sinosoft.com.concurrentdesign.concurrent02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class T01_ConCurrentMap {

	public static void main(String[] args) {
		
		Map<String,String> map = new ConcurrentHashMap<String,String>();//高并发无需排序
//		Map<String,String> map = new ConcurrentSkipListMap<String,String>();//高并发排序
//		Map<String,String> map = new Hashtable<String,String>();
//		Map<String,String> map = new HashMap<>(); //Collections.synchronizedXXX  
		Thread[] thd = new Thread[100];
		Random random = new Random();
		CountDownLatch latch = new CountDownLatch(thd.length);
		long start = System.currentTimeMillis();
		for(int i=0;i<thd.length;i++){
			thd[i] = new Thread(()->{
				for(int j=0;j<10000;j++){
					map.put("a"+random.nextInt(1000000),"a"+random.nextInt(1000000));
				}
				latch.countDown();
			});
		}
		Arrays.asList(thd).forEach(t->t.start());
		
        try {
			
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(map.size());
		System.out.println(end - start);
		
//		List<String> list = new ArrayList<String>();
//		Map<String,String> map1 = new HashMap<String,String>();
//		map1.put("123","12312");
//		map1.put("1235","12412412");
//		for(Entry<String, String> entry : map1.entrySet()){
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
	}
	
}
