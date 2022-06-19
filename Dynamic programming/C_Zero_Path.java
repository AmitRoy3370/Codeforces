import java.util.Scanner;

public class C_Zero_Path {
	
	static Scanner in = new Scanner(System.in);
	
	static StringBuilder ans = new StringBuilder();
	
	static int testCases, n, m;
	
	static int a[][];
	
	static void solve(int t) {
		
		if((n + m - 1) % 2 == 1 ) {
			
			ans.append("NO");
			
			if(t != testCases) {
				
				ans.append("\n");
				
			}
			
			return;
			
		}
		
		int dpMax[][] = new int[n + 1][m + 1];
		int dpMin[][] = new int[n + 1][m + 1];
		
		for(int i = 0; i <= n; ++i) {
			
			for(int j = 0; j <= m; ++j) {
				
				dpMax[i][j] = Integer.MIN_VALUE;
				dpMin[i][j] = Integer.MAX_VALUE;
				
			}
			
		}
		
		dpMax[0][1] = 0;
		dpMin[0][1] = 0;
		
		for(int i = 1; i <= n; ++i) {
			
			for(int j = 1; j <= m; ++j) {
				
				dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i][j - 1]) + a[i][j];
				dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i][j - 1]) + a[i][j];
				
			}
			
		}
		
		//print(dpMax);
		
		if(dpMax[n][m] >= 0 && dpMin[n][m] <= 0) {
			
			ans.append("YES");
			
		} else {
			
			ans.append("NO");
			
		}
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0 ; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			a = new int[n + 1][m + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				for(int j = 1; j <= m; ++j) {
					
					a[i][j] = in.nextInt();
					
				}
				
			}
			
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	static void print(int dp[][]) {
		
		for(int i[] : dp) {
			
			for(int j : i) {
				
				System.out.print(j + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
}