import java.util.Scanner;

public class A_Secret_Sport {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static char x[];
	
	static void solve() {
		
		System.out.println(x[n - 1]);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
}