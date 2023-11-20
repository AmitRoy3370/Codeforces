import java.util.Scanner;

public class D_Absolute_Beauty {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		
		long ans = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			ans += Math.abs(a[i] - b[i]);
			
			max = Math.max(max, Math.min(a[i], b[i]));
			min = Math.min(min, Math.max(a[i], b[i]));
			
		}
		
		if(max > min) {
			
			ans += 2L * (max - min);
			
		}
		
		System.out.println(ans);
			
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		b = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}