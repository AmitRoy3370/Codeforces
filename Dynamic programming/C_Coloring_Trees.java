import java.util.Scanner;

public class C_Coloring_Trees {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, k;
	
	static int c[];
	static long p[][];
	
	static void solve() {
		
		long dp[][][] = new long[n + 1][k + 1][m + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 0; j <= k; ++j) {
				
				for(int _k = 0; _k <= m; _k++) {
					
					dp[i][j][_k] = (long)(1E18);
					
				}
				
			}
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 1; j <= Math.min(i, k); ++j) {
				
				for(int _k = 1; _k <= m; _k++) {
					
					if(c[i] >= 1) {
						
						if(_k == c[i]) {
							
							dp[i][j][c[i]] = Math.min(dp[i][j][c[i]], dp[i - 1][j][_k]);
							
						} else {
							
							dp[i][j][c[i]] = Math.min(dp[i][j][c[i]], dp[i - 1][j - 1][_k]);
							
						}
						
						continue;
						
					}
					
					for(int l = 1; l <= m; ++l) {
						
						if(l == _k) {
							
							dp[i][j][l] = Math.min(dp[i][j][l], dp[i - 1][j][_k] + p[i][l]);
							
						} else {
							
							dp[i][j][l] = Math.min(dp[i][j][l], dp[i - 1][j - 1][_k] + p[i][l]);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		long min = (long)(1E18);
		
		if(c[n] >= 1L) {
			
			min = Math.min(min, dp[n][k][c[n]]);
			
		} else {
			
			for(int i = 1; i <= m; ++i) {
				
				min = Math.min(min, dp[n][k][i]);
				
			}
			
		}
		
		if(min >= (long)(1E18)) {
			
			System.out.println(-1);
			
		} else {
			
			System.out.println(min);
			
		}
		
		//print(dp);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			k = in.nextInt();
			
			c = new int[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				c[i] = in.nextInt();
				
			}
			
			p = new long[n + 1][m + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				for(int j = 1; j <= m; ++j) {
					
					p[i][j] = in.nextLong();
					
				}
				
			}
			
			solve();
			
		}
		
	}
	
	static void print(long dp[][][]) {
		
		for(long i[][] : dp) {
			
			for(long j[] : i) {
				
				for(long k : j) {
					
					System.out.print(k + " ");
					
				}
				
				System.out.print("	");
				
			}
			
			System.out.println();
			
		}
		
	}
	
}