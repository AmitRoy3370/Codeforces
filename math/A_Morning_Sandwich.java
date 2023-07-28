import java.util.Scanner;

public class A_Morning_Sandwich {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, bread, cheese, ham;
	
	static void solve() {
		
		int layer = Math.min(2 * bread - 1, (cheese + ham) * 2 + 1);
		
		System.out.println(layer);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		bread = in.nextInt();
		
		cheese = in.nextInt();
		
		ham = in.nextInt();
		
	}
	
}