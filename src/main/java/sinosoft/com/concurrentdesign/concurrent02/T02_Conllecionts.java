package sinosoft.com.concurrentdesign.concurrent02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T02_Conllecionts {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		List<String> listSyn = Collections.synchronizedList(list);
		Map<String,String> map = new HashMap<String,String>();
		Collections.synchronizedMap(map); // 将hashmap变为安全的
		Set<String> set = new HashSet<String>();
		Collections.synchronizedSet(set);
		
	}
}
