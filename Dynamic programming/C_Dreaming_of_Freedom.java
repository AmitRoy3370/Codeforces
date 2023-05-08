import java.util.Scanner;

public class C_Dreaming_of_Freedom {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, N = 1000005;
	static long m;
	
	static long dp[];
	
	static void make_dp() {
		
		dp = new long[N];
		
		for(int i = 2; i < N; ++i) {
			
			if(dp[i] != 0L) {
				
				continue;
				
			}
			
			dp[i] = i;
			
			for(int j = 2 * i; j < N; j += i) {
				
				if(dp[j] == 0L) {
					
					dp[j] = i;
					
				}
				
			}
			
		}
		
	}
	
	static void solve() {
		
		if(n != 1 && n % 2 == 0 && m >= 2) {
			
			System.out.println("NO");
			return;
			
		}
		
		if(n != 1 && n % 2 == 1 && m >= n) {
			
			System.out.println("NO");
			return;
			
		}
		
		if(n == 1 || dp[n] > m || m == 1) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		make_dp();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextLong();
			
			solve();
			
		}
		
	}
	
}