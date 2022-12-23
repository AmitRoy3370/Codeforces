import java.util.Scanner;

public class A_Park_Lighting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static void solve() {
		
		int ans = (int)Math.ceil((double)((double)n * (double)m) / 2.0);
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			solve();
			
		}
		
	}
	
}