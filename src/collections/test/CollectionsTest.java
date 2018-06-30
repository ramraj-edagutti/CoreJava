package collections.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionsTest {
	
	public static void main(String[] args) {
		getMapKeyValues();
		//collectionCopy();
	}
	
	public static void collectionCopy() {
		List<String> allPPAAbortJobs = new ArrayList<String>();
		allPPAAbortJobs.add("PPPCacheDrain");
		allPPAAbortJobs.add("PPPIncentCleanup");
		allPPAAbortJobs.add("PPPAbortMetadata");
		allPPAAbortJobs.add("PPPResetCalc");
		allPPAAbortJobs.add("PPARepoDelete");
		allPPAAbortJobs.add("PPPRunDataCleanup");
		
		List<String> pendingJobs = new ArrayList<String>(allPPAAbortJobs);
		pendingJobs.remove("PPPAbortMetadata");
		pendingJobs.remove("PPPIncentCleanup");
		
		System.out.println(allPPAAbortJobs.toString());
		System.out.println(pendingJobs.toString());
	}
	
	public static void collectionSort() {
		List<Long> ids = new ArrayList<Long>();
		//ids.add(50L);
		//ids.add(20L);
		ids.addAll(new ArrayList<Long>());
		System.out.println("ids.."+ids);
		Collections.sort(ids);
		System.out.println("Sorted ids..."+ids);
		Long[] longArray = ids.toArray(new Long[ids.size()]);
		System.out.println(longArray.toString());
	}
	
	public static void getMapKeyValues() {
		Map map = new HashMap();
		
		map.put(0, "Plan");
		map.put(1, "Assignment Name");
		map.put(2, "Assignment Type");
		
		if (map.containsValue("assignment Name")) {
			System.out.println("Assignment Name contains true");
		}
		/*Iterator itr = map.values().iterator();
		while (itr.hasNext()) {
			System.out.println((String)itr.next());
		}*/
		
	}

}
