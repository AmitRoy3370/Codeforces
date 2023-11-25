import java.util.Scanner;

public class B_Chip_and_Ribbon {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long teleport = 0L;
		
		for(int i = 1; i < n; ++i) {
			
			teleport += Math.max(0L, a[i] - a[i - 1]);
			
		}
		
		teleport += a[0] - 1L;
		
		System.out.println(teleport);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}