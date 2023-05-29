import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Array_merging {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		Map<Long, Integer> A = new HashMap<>();
		
		Map<Long, Integer> B = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			long element = a[i];
			
			int frequency = 1;
			
			while(i + 1 < n && a[i + 1] == element) {
				
				++frequency;
				
				++i;
				
			}
			
			A.put(element, Math.max(A.getOrDefault(element, 0), frequency));
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			long element = b[i];
			
			int frequency = 1;
			
			while(i + 1 < n && b[i + 1] == element) {
				
				++frequency;
				
				++i;
				
			}
			
		    B.put(element, Math.max(B.getOrDefault(element, 0), frequency));
			
		}
		
		long sum = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			sum = Math.max(sum, A.getOrDefault(a[i], 0) + B.getOrDefault(a[i], 0));
			
			sum = Math.max(sum, A.getOrDefault(b[i], 0) + B.getOrDefault(b[i], 0));
			
		}
		
		System.out.println(sum);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		b = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextLong();
			
		} 
		
	}
		
}