import java.util.Scanner;

public class A_Wallet_Exchange {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a, b;
	
	static void solve() {
		
		long total_coint = a + b;
		
		if(total_coint % 2 == 0) {
			
			System.out.println("Bob");
			
		} else {
			
			System.out.println("Alice");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextLong();
		b = in.nextLong();
		
	}
	
}