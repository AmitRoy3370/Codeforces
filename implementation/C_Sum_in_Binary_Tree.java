import java.util.Scanner;

public class C_Sum_in_Binary_Tree {
	
	static int testCases;
	
	static long n;
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		long sum = 0L;
		
		while(n > 0L) {
			
			sum += n;
			
			n /= 2L;
			
		}
		
		System.out.println(sum);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		
	}
	
}