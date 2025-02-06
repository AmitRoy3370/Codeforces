import java.util.Scanner;

public class D_Buying_Shovels {
	
	static Scanner in = new Scanner(System.in);
	
	static long n, k;
	static int testCases;
	
	static void solve() {
		
		if(k >= n) {
			
			System.out.println(1);
			
		} else {
			
			if(k == 1) {
				
				System.out.println(n);
				
			} else {
				
				long packages = n;
				
				for(long i = 2L; i * i <= n; ++i) {
					
					if(n % i == 0) {
						
						packages = Math.min(Math.min(i <= k ? n / i : Long.MAX_VALUE, (n / i) <= k ? n / (n / i) : Long.MAX_VALUE), packages);
						
					}
					
				}
				
				System.out.println(packages);
				
			}
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		k = in.nextLong();
		
	}
	
}