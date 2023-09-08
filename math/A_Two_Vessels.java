import java.util.Scanner;

public class A_Two_Vessels {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b, c;
	
	static void solve() {
		
		int mid = (int)Math.ceil((double)((double)a + (double)b) / 2.0);
		
		mid -= Math.min(a, b);
		
		mid = (int)Math.ceil((double)mid / (double)c);
		
		System.out.println(mid);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextInt();
		
		b = in.nextInt();
		
		c = in.nextInt();
		
	}
	
}