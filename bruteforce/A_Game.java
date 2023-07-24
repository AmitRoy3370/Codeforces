import java.util.Scanner;

public class A_Game {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n1, n2, k1, k2;
	
	static void solve() {
		
		String winner = n1 > n2 ? "First" : "Second";
		
		System.out.println(winner);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n1 = in.nextInt();
		n2 = in.nextInt();
		
		k1 = in.nextInt();
		k2 = in.nextInt();
		
	}
	
}