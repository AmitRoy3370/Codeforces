import java.util.Scanner;

public class E_Exchange {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	static long n, a, b;
	
	static void solve() {
		
		if(a > b) {
			
			System.out.println(1L);
			
		} else {
			
			long ans = (long)Math.ceil((double)((double)n / (double)a));
			
			System.out.println(ans);
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextLong();
			
			a = in.nextLong();
			
			b = in.nextLong();
			
			solve();
			
		}
		
	}
	
}