import java.util.Scanner;

public class A_Exponential_Equation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	static long N;
	
	static void solve() {
		
		if(N % 2 == 1) {
			
			System.out.println(-1);
			
		} else {
			
			System.out.println(1 + " " + (N / 2L));
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			N = in.nextLong();
			
			solve();
			
		}
		
	}
	
}