import java.util.Scanner;

public class A_Vasya_and_Coins {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long a, b;
	
	static void solve() {
		
		if(a == 0 || (a == 0 && b == 0)) {
			
			System.out.println(1);
			
		} else {
			
			long ans = 2 * b + 1 + a;
			
			System.out.println(ans);
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.nextLong();
			b = in.nextLong();
			
			solve();
			
		}
		
	}
	
}