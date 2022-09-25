import java.util.Scanner;

public class B_String_Mood {
	
	static Scanner in = new Scanner(System.in);
	
	static long n, mod = (long)(1e9 + 7L);
	
	static void solve() {
		
		long dp[][] = new long[2][2];
		
		// here the 0 index mention happy
		// here the 1 index mention the sad
		
		long unit[][] = new long[2][2];
		
		for(int i = 0; i < 2; ++i) {
			
			unit[i][i] = 1L;
			
		}
		
		dp[0][0] = 19L;
		// happy to happy that means
		// we need 5 character to change
		// and 2 character for sad. So,
		// we have now 26 - (5 + 2) = 19
		// character alive
		
		dp[1][1] = 20L;
		// sad to sad that means
		// we need 5 character to change
		// and 1 character for happy. So,
		// we have now 26 - (5 + 1) = 20
		// character alive
		
		dp[0][1] = 7L;
		// happy to sad
		// we need 5 character to switch mood
		// and 2 character to be sad.
		// so we need 7 character to do that
		
		dp[1][0] = 6L;
		// sad to happy
		// we need 5 character to switch mood
		// and 1 character to be happy so we
		// have now 6 character alive
		
		// use binary exponentiation to detect
		// the 26^n possible string
		while(n > 0L) {
			
			if(n % 2L == 1L) {
				
				unit = mul(dp, unit);
				
			}
			
			dp = mul(dp, dp);
			
			n /= 2L;
			
		}
		
		System.out.print(unit[0][0]);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextLong();
		
		solve();
		
	}
	
	static long[][] mul(long mat[][], long a[][]) {
		
		int n = mat.length;
		
		long ans[][] = new long[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				//ans[i][j] = 0.0;
				
				for(int k = 0; k < n; ++k) {
					
					ans[i][k] += a[i][j] * mat[j][k];
					
					ans[i][k] %= mod;
					
				}
				
			}
			
		}
		
		return ans;
		
	}
	
}