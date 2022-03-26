import java.util.Scanner;

public class D_K_good {
	
	private static Scanner in = new Scanner(System.in);
	
	private static long n;
	
	private static int testCases;
	
	private static void solve() {
		
		long x = n;
		
		long k = 2;
		
		while(x > 0 && x % k == 0) {
			
			x /= k;
			
		}
		
		if(x == 1) {
			
			System.out.println(-1);
			
		} else if(x <= (long)2e9 && (x * (x + 1)) / 2 <= n) {
			
			System.out.println(x);
			
		} else {
			
			System.out.println(k * (n / x) );
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextLong();
			
			solve();
			
		}
		
	}
	
}