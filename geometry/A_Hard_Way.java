import java.util.Scanner;

public class A_Hard_Way {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long x[], y[];
	
	static void solve() {
		
		// first point
		
		long a = x[0];
		long b = y[0];
		
		// second point
		
		long c = x[1];
		long d = y[1];
		
		// third point
		
		long e = x[2];
		long f = y[2];
		
		long unsafe = 0L;
		
		if(b == f && b > d) {
			
			unsafe = Math.abs(a - e);
			
		} else if(d == f && f > b) {
			
			unsafe = Math.abs(e - c);
			
		} else if(b == d && f < d) {
			
			unsafe = Math.abs(a - c);
			
		}
		
		
		System.out.println(unsafe);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = 3;
		
		x = new long[n];
		
		y = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			x[i] = in.nextLong();
			y[i] = in.nextLong();
			
		}
		
	}
	
}