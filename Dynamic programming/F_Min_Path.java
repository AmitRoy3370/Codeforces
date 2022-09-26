import java.util.Scanner;

public class F_Min_Path {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static long k;
	
	static long graph[][];
	
	static long inf = (long)((long)(3e18) + 5L);
	
	static void solve() {
		
		long unit[][] = new long[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				unit[i][j] = inf;
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			unit[i][i] = 0L;
			
		} 
		
		while(k > 0L) {
			
			if(k % 2L == 1L) {
				
				unit = mul(unit, graph);
				
			}
			
			graph = mul(graph, graph);
			
			k /= 2L;
			
		}
		
		long min = inf;
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				min = Math.min(unit[i][j], min);
				
			} 
			
		}
		
		if(min >= inf / 2L) {
			
			System.out.print("IMPOSSIBLE");
			
		} else {
			
			System.out.print(min);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextLong();
		
		graph = new long[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				graph[i][j] = inf;
				
			}
			
		} 
		
		for(int i = 0; i < m; ++i) {
			
			graph[in.nextInt() - 1][in.nextInt() - 1] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	
    static long[][] mul(long a[][], long b[][]) {

        int len = a.length;

        long ans[][] = new long[len][len];
		
		for(int i = 0; i < len; ++i) {
			
			for(int j = 0; j < len; ++j) {
				
				ans[i][j] = inf;
				
			}
			
		}
 
        for (int i = 0; i < len; ++i) {

            for (int j = 0; j < len; ++j) {

                for (int k = 0; k < len; ++k) {

                    ans[i][k] = Math.min(ans[i][k], a[i][j] + b[j][k]);

                    //ans[i][k] %= mod;

                }

            }

        }

        return ans;

    }
	
}