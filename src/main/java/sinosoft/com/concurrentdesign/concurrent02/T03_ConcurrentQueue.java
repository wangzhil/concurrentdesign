package sinosoft.com.concurrentdesign.concurrent02;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T03_ConcurrentQueue {

	public static void main(String[] args) {
		Queue<String> queue = new ConcurrentLinkedQueue<String>();
//		for(int i=0;i<10;i++){
//			queue.offer("a"+i); //add
//		}
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.poll());//remove
		System.out.println(queue.size());
		System.out.println(queue.peek());//element
		System.out.println(queue.size());
	}
}
