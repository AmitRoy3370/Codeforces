import java.util.Scanner;

public class A_Line_Trip {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		long fuel = Long.MAX_VALUE;
		
		fuel = Math.min(fuel, a[0] - 0L);
		
		for(int i = 1; i < n; ++i) {
			
			fuel = Math.max(fuel, a[i] - a[i - 1]);
			
		}
		
		fuel = Math.max(fuel, 2L * (k - a[n - 1]));
		
		System.out.println(fuel);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}