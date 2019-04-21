package sinosoft.com.concurrentdesign.concurrent01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {

	@Override
	public void execute(Runnable command) {
		
		//new Thread(command).run();
				command.run();
	}
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> map1 = new ConcurrentHashMap<String,String>();
		new T01_MyExecutor().execute(()->System.out.println("Hello executor"));
	}

	
}
