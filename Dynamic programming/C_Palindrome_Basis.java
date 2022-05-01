import java.util.Scanner;

public class C_Palindrome_Basis {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long mod = (long)((long)(1e9) + 7);
	
	static long dp[] = new long[40001];
	
	static void solve() {
		
		dp[0] = 1;
		
		for(int i = 1; i <= 40000; ++i) {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(i);
			
			sb.reverse();
			
			if(Integer.parseInt(sb.toString()) == i) {
				
				for(int j = i; j <= 40000; ++j) {
					
					dp[j] += dp[j - i];
					dp[j] %= mod;
					
				}
				
			}
			
		}
		
		/*for(int i = 0; i <= 7; ++i) {
			
			System.out.print(dp[i] + " ");
			
		}
		
		System.out.println();*/
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		solve();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			System.out.println(dp[n]);
			
		}
		
	}
	
}