import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class D1_Balance_Easy_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static long inserted;
	
	static char operation;
	
	static Map<Long, Integer> map = new HashMap<>();
	
	static StringBuilder sb = new StringBuilder();
	
	static Map<Long, Long> previous_ans = new HashMap<>();
	
	static void solve() {
		
		if(operation == '+') {
			
			map.put(inserted, map.getOrDefault(inserted, 0) + 1);
			
		} else {
			
			long now = previous_ans.getOrDefault(inserted, 0L);
			
			while(map.containsKey(now) && map.getOrDefault(now, 0) > 0) {
				
				//previous_ans.put(now, inserted);
				
				now += inserted;
				
			}
			
			previous_ans.put(inserted, now);
			
			sb.append(now).append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		map.put(0L, 1);
		
		for(int t = 0; t < testCases; ++t) {
			
			operation = in.next().charAt(0);
			
			inserted = in.nextLong();
			
			solve();
			
		}
		
		System.out.println(sb.toString());
		
	}
	
}