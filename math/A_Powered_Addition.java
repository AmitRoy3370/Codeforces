import java.util.Scanner;

public class A_Powered_Addition {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long maxDifference = 0;
		
		long leftMax = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			if(leftMax > a[i]) {
			
			   maxDifference = Math.max(maxDifference, leftMax - a[i]);
			   //leftMax = a[i];
			
			} else {
				
				leftMax = a[i];
				
			}
			
		}
		
		if(maxDifference <= 0) {
			
			System.out.println(0);
			
		} else {
			
			long x = (long)(Math.log(maxDifference) / Math.log(2));
			++x;
			
			System.out.println(x);
			
		}
		
	}
	
	public static void main(String [] Priya) {
		
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
	
}