import java.util.Scanner;

public class A_Game_with_Integers {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static void solve() {
		
		if((n + 1) % 3 == 0 || (n - 1) % 3 == 0) {
			
			System.out.println("First");
			
		} else {
			
			System.out.println("Second");
			
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
		
		n = in.nextInt();
		
	}
	
}