import java.util.Scanner;

public class C_Fill_in_the_Matrix {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		if(m == 1) {
			
			ans.append(0).append("\n");
			
		} else if(m > n + 1) {
			
			ans.append((n + 1)).append("\n");
			
		} else {
			
			ans.append(m).append("\n");
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			int start = Math.max(m - i, 1);
			
			StringBuilder sb = new StringBuilder();
			
			for(int j = start; j < start + m; ++j) {
				
				sb.append((j % m)).append(" ");
				
			}
			
			ans.append(sb.toString().trim());
			
			if(i != n) {
				
				ans.append("\n");
				
			}
			
		}
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
	}
	
}