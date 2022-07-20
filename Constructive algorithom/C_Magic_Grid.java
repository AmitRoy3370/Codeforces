import java.util.Scanner;

public class C_Magic_Grid {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static void solve() {
		
		long a[][] = new long[n][n];
		
		long number = 0;
		
		for(int i = 0; i < n / 2; ++i) {
			
			for(int j = 0; j < n / 2; ++j) {
				
				a[i][j] = 4 * number + 1;
				a[i][j + n / 2] = 4 * number + 2;
				a[i + n / 2][j] = 4 * number + 3;
				a[i + n / 2][j + n / 2] = 4 * number;
				
				++number;
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				sb.append(a[i][j]).append(" ");
				
			}
			
			sb.append("\n");
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		solve();
		
	}
	
}