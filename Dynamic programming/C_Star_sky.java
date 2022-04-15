import java.util.Scanner;

public class C_Star_sky {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, n, t, c, s, x, y, x1, y1, x2, y2;
	
	private static int dp[][][];
	
	private static void solve() {
		
		long ans = 0;
		
		for(int i = 0; i <= c; ++i) {
			
			int brightness = (i + t) % (c + 1);
			
			int amount = dp[i][x2][y2] - dp[i][x1 - 1][y2] - dp[i][x2][y1 - 1] + dp[i][x1 - 1][y1 - 1];
			
			ans += amount * brightness;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		testCases = in.nextInt();
		
		c = in.nextInt();
		
		dp = new int[c + 1][101][101];
		
		for(int i = 0; i < n; ++i) {
			
			x = in.nextInt();
			y = in.nextInt();
			s = in.nextInt();
			
			dp[s][x][y]++;
			
		}
		
		for(int p = 0; p <= c; ++p) {
			
			for(int i = 1; i <= 100; ++i) {
				
				for(int j = 1; j <= 100; ++j) {
					
					dp[p][i][j] += dp[p][i - 1][j] + dp[p][i][j - 1] - dp[p][i - 1][j - 1];
					
				}
				
			}
			
		}
		
		for(int i = 0; i < testCases; ++i) {
			
			t = in.nextInt();
			x1 = in.nextInt();
			y1 = in.nextInt();
			x2 = in.nextInt();
			y2 = in.nextInt();
			
			solve();
			
		}
		
	}
	
}