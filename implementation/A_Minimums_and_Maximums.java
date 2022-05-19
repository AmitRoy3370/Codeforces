import java.util.Scanner;

public class A_Minimums_and_Maximums {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, l1, l2, r1, r2;
	
	static void solve() {
		
		if(Math.max(l1, l2) <= Math.min(r1, r2)  ) {
			
			System.out.println(Math.max(l1, l2));
			
		} else {
			
			System.out.println((l1 + l2));
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			l1 = in.nextInt();
			r1 = in.nextInt();
			l2 = in.nextInt();
			r2 = in.nextInt();
			
			solve();
			
		}
		
	}
	
}