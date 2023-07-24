import java.util.Scanner;

public class C_Particles {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int negative = 0;
		
		for(long i : a) {
			
			if(i < 0L) {
				
				++negative;
				
			}
			
		}
		
		if(negative == n) {
			
			long max = max(a);
			
			System.out.println(max);
			
			return;
			
		}
		
		long count1 = 0L, count2 = 0L;
		
		for(int i = 0; i < n; i += 2) {
			
			if(a[i] > 0L) {
				
				count1 += a[i];
				
			}
			
		}
		
		for(int i = 1; i < n; i += 2) {
			
			if(a[i] > 0L) {
				
				count2 += a[i];
				
			}
			
		}
		
		long ans = Math.max(count1, count2);
		
		System.out.println(ans);
		
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
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static long max(long a[]) {
		
		long max = a[0];
		
		for(long i : a) {
			
			max = Math.max(i, max);
			
		}
		
		return max;
		
	}
	
}