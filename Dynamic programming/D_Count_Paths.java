import java.util.Scanner;

public class D_Count_Paths {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static long k, mod = (long)(1e9 + 7L);
	
	static long graph[][];
	
	static void solve() {
		
		long unit[][] = new long[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			unit[i][i] = 1L;
			
		}
		
		while(k > 0L) {
			
			if(k % 2L == 1L) {
				
				unit = mul(unit, graph);
				
			}
			
			graph = mul(graph, graph);
			
			k /= 2L;
			
		}
		
		long ans = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				ans += (unit[i][j]);
				
				ans %= mod;
				
			}
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextLong();
		
		graph = new long[n][n];
		
		for(int i = 0; i < m; ++i) {
			
			graph[in.nextInt() - 1][in.nextInt() - 1] = 1L;
			
		}
		
		solve();
		
	}
	
    static long[][] mul(long a[][], long b[][]) {

        int len = a.length;

        long ans[][] = new long[len][len];

        for (int i = 0; i < len; ++i) {

            for (int j = 0; j < len; ++j) {

                for (int k = 0; k < len; ++k) {

                    ans[i][k] += a[i][j] * b[j][k];

                    ans[i][k] %= mod;

                }

            }

        }

        return ans;

    }

}