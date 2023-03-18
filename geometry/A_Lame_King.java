import java.util.Scanner;

public class A_Lame_King {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b;
	
	static void solve() {
		
		a = Math.abs(a);
		b = Math.abs(b);
		
		int ans = 2 * Math.max(a, b) - 1;
		
		if(a == b) {
			
			ans = a + b;
			
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