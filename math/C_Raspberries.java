import java.util.Scanner;

public class C_Raspberries {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static int a[];
	
	static void solve() {
		
		long min_operations = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = k; j < 1000; j += k) {
				
				if(a[i] > j) {
					
					continue;
					
				}
				
				min_operations = Math.min(min_operations, Math.abs(a[i] - j));
			
			}
			
		}
		
		if(k == 2 || k == 3 || k == 5) {
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i] % k == 0) {
					
					System.out.println(0);
					return;
					
				}
				
			}
			
		} else {
			
			int even = 0;
			
			for(long i : a) {
				
				if(i % 2 == 0) {
					
					++even;
					
				}
				
			}
			
			min_operations = Math.min(min_operations, Math.max(0, 2 - even));
		
		}
		
		System.out.println(min_operations);
		
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
		k = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}