import java.util.Scanner;

public class B_Longest_Divisors_Interval {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long N;
	
	static void solve() {
		
		long multiply = 1L;
		
		while(N % multiply == 0L) {
			
			multiply++;
			
		}
		
		--multiply;
		
		System.out.println(multiply);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		N = in.nextLong();
		
	}
	
}