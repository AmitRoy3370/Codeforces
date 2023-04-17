import java.util.Scanner;

public class A_Li_Hua_and_Maze {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n, m, x1, y1, x2, y2;
	
	static int solve(long x, long y) {
		
		if((x == 1 || x == n) && (y == 1 || y == m)) {
			
			return 2;
			
		} else if(x == 1 || y == 1 || x == n || y == m) {
			
			return 3;
			
		}
		
		return 4;
		
	}
	
	static void solve() {
		
		long ans = Math.min(solve(x1, y1), solve(x2, y2));
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextLong();
			m = in.nextLong();
			
			x1 = in.nextLong();
			y1 = in.nextLong();
			
			x2 = in.nextLong();
			y2 = in.nextLong();
			
			solve();
			
		}
		
	}
	
}