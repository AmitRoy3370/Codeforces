import java.util.Scanner;

public class A_Subtraction_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b;
	
	static void solve() {
		
		a += b;
		
		System.out.println(a);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextInt();
		
		b = in.nextInt();
		
	}
	
}