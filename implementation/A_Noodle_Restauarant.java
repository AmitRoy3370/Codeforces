import java.util.Scanner;

public class A_Noodle_Restauarant {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[][];
	
	static void solve() {
		
		long mul = a[0][0] * a[0][n - 1] * a[n - 1][0] * a[n - 1][n - 1];
		
		System.out.println(mul);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			for(int j= 0; j < n; ++j) {
				
				a[i][j] = in.nextLong();
				
			}
			
		}
		
	}
	
}