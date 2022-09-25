import java.util.Scanner;

public class A_Greg_and_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, k;
	
	static int L[], R[], d[], x[], y[];
	
	static long a[];
	
	/*
	
	solve manually:
	
	3 3 3
	
	1 2 3 -> a
	
	1 2 1
	1 3 2
	2 3 4
	
	1 2
	1 3
	2 3
	
	(1, 2):
	
	1 1 0
	2 2 2
	......
	3 3 2
	
	(1, 3):
	
	1 1 0
	2 2 2
	0 4 4
	.......
	3 7 6
	
	(2, 3):
	
	2 2 2
	0 4 4
	......
	2 6 6
	
	total:
	
	3 3 2 .....> (1, 2)
	3 7 6 .....> (1, 3)
	2 6 6 .....> (2, 3)
	......
	8 16 14
	
	Add with the main element:
	
	9 18 17 -> final condition of the array
	
		
	*/
	
	static void solve() {
		
		long query[] = new long[m + 2];
		
		for(int i = 1; i <= k; ++i) {
			
			query[x[i - 1]]++;
			query[y[i - 1] + 1]--;
			
		}
		
		for(int i = 1; i <= m; ++i) {
			
			query[i] += query[i - 1];
			
		}
		
		long dp[] = new long[n + 2];
		
		for(int i = 1; i <= m; ++i) {
			
			dp[L[i - 1]] += query[i] * d[i - 1];
			dp[R[i - 1] + 1] -= query[i] * d[i - 1];
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			dp[i] += dp[i - 1];
			
			long ans = dp[i] + a[i - 1];
			
			System.out.print(ans + " ");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		} 
		
		L = new int[m];
		R = new int[m];
		d = new int[m];
		
		for(int i = 0; i < m; ++i) {
			
			L[i] = in.nextInt();
			R[i] = in.nextInt();
			d[i] = in.nextInt();
			
		}
		
		x = new int[k];
		y = new int[k];
		
		for(int i = 0; i < k; ++i) {
			
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}