import java.util.Scanner;

public class B_Good_Sequences {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, n;
	
	private static int a[];
	
	private static void solve() {
		
		int max = a[0];
		
		for(int i : a) {
			
			max = Math.max(i, max);
			
		}
		
		long dp[] = new long[max + 1];
		long d[] = new long[max + 1];
		
		max = 0;
		
		for(int i = 0; i < n; ++i) {
			
			int number = a[i];
            
			d[number] = 1;
            dp[number] = d[number];			
			
			for(int j = 2; j * j <= number; ++j) {
				
			  if(number % j == 0)	
				
				dp[number] = Math.max(dp[number], Math.max(d[j], d[number / j]) + 1 );
				
			}
			
			for(int j = 2; j * j <= number; ++j) {
				
				if(number % j == 0) {
					
					d[j] = dp[number];
					d[number / j] = dp[number];
					
				}
                    					
			}
			
			max = (int)Math.max(max, dp[number]);
			
		}
		
		System.out.print(max);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}