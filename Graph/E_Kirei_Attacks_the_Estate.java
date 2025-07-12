import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class E_Kirei_Attacks_the_Estate {
	
	static Scanner in = new Scanner(System.in);
	static int testCases, n;
	static List<Integer> list[];
	static long a[];
	
	static void dfs(int src, int parent, long difference[], long dp[]) {
		
		dp[src] = Math.max(a[src], a[src] - difference[parent]);
		difference[src] = a[src] - dp[parent];
		
		for(int child : list[src]) {
			
			if(parent == child) {
				
				continue;
				
			}
			
			dfs(child, src, difference, dp);
			
		}
		
	}
	
	static void solve() {
		
		long difference[] = new long[n + 1];
		long dp[] = new long[n + 1];
		
		StringBuilder sb = new StringBuilder();
		
		dfs(1, 0, difference, dp);
		
		for(int i = 1; i <= n; ++i) {
			
			sb.append(dp[i]).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		list = new ArrayList[n + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			list[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < n - 1; ++i) {
			
			int u = in.nextInt();
			int v = in.nextInt();
			
			list[u].add(v);
			list[v].add(u);
			
		}
		
	}
	
}