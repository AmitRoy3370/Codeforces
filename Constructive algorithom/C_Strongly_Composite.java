import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class C_Strongly_Composite {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		List<Long> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			long element = a[i];
			
			for(long j = 2L; j * j <= a[i]; ++j) {
				
				if(element % j == 0L) {
					
					if(!map.containsKey(j)) {
						
						list.add(j);
						
					}
					
				}
				
				while(element % j == 0L) {
					
					map.put(j, map.getOrDefault(j, 0) + 1);
					
					element /= j;
					
				}
				
			}
			
			if(element != 1L) {
				
				if(!map.containsKey(element)) {
					
					list.add(element);
					
				}
				
				map.put(element, map.getOrDefault(element, 0) + 1);
				
			}
			
		} 
		
		long two_prime_count = 0L, three_prime_count = 0L;
		
		for(long i : list) {
			
			two_prime_count += (map.getOrDefault(i, 0)) / 2L;
			
			three_prime_count += (map.getOrDefault(i, 0)) % 2L;
			
		}
		
		long ans = two_prime_count + three_prime_count / 3L;
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}