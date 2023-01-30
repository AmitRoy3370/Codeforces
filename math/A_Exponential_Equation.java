import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Exponential_Equation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	static long N;
	
	static void solve() {
		
		Map<Long, Integer> map = new HashMap<>();
		
		long max = 1L;
		
		long n = N;
		
		for(long i = 2L; i * i <= n; ++i) {
			
			int count = 0;
			
			if(N % i == 0L) {
				
				++count;
				
				N /= i;
				
				while(N % i == 0L) {
					
					++count;
					N /= i;
					
				}
				
				map.put(i, count);
				
				if(count > max) {
					
					max = count;
					
				}
				
			}
			
		}
		
		//System.out.println(N);
		
		if(N > 1L) {
			
			map.put(N, 1);
			//++max;
			
		}
		
		long ans = 0L;
		
		//System.out.println(max);
		
		/*for(long i : map.keySet()) {
			
			System.out.println(i + " " + map.get(i));
			
		}*/
		
		for(long i = 1; i <= max; ++i) {
			
			long now = 1L;
			
			for(long j : map.keySet()) {
				
				if(map.get(j) <= 0) {
					
					continue;
					
				}
				
				now *= j;
				
				map.put(j, map.get(j) - 1);
				
			}
			
			ans += now;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			N = in.nextLong();
			
			solve();
			
		}
		
	}
	
}