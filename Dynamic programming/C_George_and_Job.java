import java.util.Scanner;
import java.util.PriorityQueue;

public class C_George_and_Job {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, k;
	
	static long a[];
	
	static void solve() {
		
		long dp[][] = new long[n + 1][k + 1];
		
		long prefix[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		dp[1][1] = prefix[1];
		
		for(int i = m; i <= n; ++i) {
			
			for(int j = 1; j <= k; ++j) {
				
				long take = dp[i - m][j - 1] + (prefix[i] - prefix[i - m]);
				
				dp[i][j] = Math.max(dp[i - 1][j], take);
				
			}
			
		}
		
		System.out.println(dp[n][k]);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static class element implements Comparable<element> {
		
		long element;
		
		public element(long element) {
			
			this.element = element;
			
		}
		
		public int compareTo(element e) {
			
			if(this.element > e.element) {
				
				return -1;
				
			} else if(this.element < e.element) {
				
				return 1;
				
			}
			
			return 0;
			
		}
		
	}
	
}