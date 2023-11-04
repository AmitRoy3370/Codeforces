import java.util.Scanner;

public class A_Treasure_Chest {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, x, y, k;
	
	static void solve() {
		
		if(x >= y) {
			
			System.out.println(x);
			
		} else {
			
			if(y - x <= k) {
				
				System.out.println(y);
				
			} else {
				
				long ans = 2 * y - (x + k);
				
				System.out.println(ans);
				
			}
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.nextInt();
		y = in.nextInt();
		k = in.nextInt();
		
	}
	
}