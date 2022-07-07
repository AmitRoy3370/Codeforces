import java.util.Scanner;

public class B_Almost_Ternary_Matrix {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		char dp[][] = new char[n][m];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < m; ++j) {
				
				dp[i][j] = '0';
				
			}
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 1; j <= m; ++j) {
				
				dp[i - 1][j - 1] = (((i % 4 <= 1) != (j % 4 <= 1)) ? '1' : '0');
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < m; ++j) {
				
				sb.append(dp[i][j]).append(" ");
				
			}
			
			ans.append(sb.toString().trim());
			
			if(i != n - 1) {
				
				ans.append("\n");
				
			}
			
		}
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			solve(t + 1);
			
		}
		
		System.out.println(ans.toString());
		
	}
	
}