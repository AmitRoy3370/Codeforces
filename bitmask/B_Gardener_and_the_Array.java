import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class B_Gardener_and_the_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static List<List<Long>> list;
	
	static void solve() {
		
		Map<Long, Long> map = new HashMap<>(); 
		
		for(int i = 0; i < n; ++i) {
			
			List<Long> a = list.get(i);
			
			for(long j : a) {
				
				map.put(j, map.getOrDefault(j, 0L) + 1L);
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			List<Long> a = list.get(i);
			
			int iteration = 0;
			
			for(long j : a) {
				
				if(map.get(j) > 1) {
					
					++iteration;
					
					continue;
					
				}
				
				break;
				
			}
			
			if(iteration == a.size()) {
				
				System.out.println("YES");
				return;
				
			}
			
		}
		
		System.out.println("NO");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			list = new ArrayList<>();
			
			for(int i =  0; i < n; ++i) {
				
				int m = in.nextInt();
				
				List<Long> a = new ArrayList<>();
				
				for(int j = 0; j < m; ++j) {
					
					a.add(in.nextLong());
					
				}
				
				list.add(a);
				
			}
			
			solve();
			
		}
		
	}
	
}