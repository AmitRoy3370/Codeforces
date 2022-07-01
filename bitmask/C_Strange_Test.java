import java.util.Scanner;

public class C_Strange_Test {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b;
	
	static void solve() {
		
		int ans = b - a;
		
		for(int i = a; i < b; ++i) {
			
			int temp = i | b;
			
			ans = Math.min(ans, i - a + 1 + temp - b);
			
		}
		
		for(int i = b; i < b + a; ++i) {
			
			int temp = i | a;
			
			ans = Math.min(ans, i - b + 1 + temp - i);
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.nextInt();
			b = in.nextInt();
			
			solve();
			
		}
		
	}
	
}