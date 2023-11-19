import java.util.Scanner;

public class C_Yarik_and_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long maximum_sum = a[0];
		
		long sum = a[0];
		
		long previous_substraction = Math.min(0L, a[0]);
		
		for(int i = 1; i != n; ++i) {
			
			if(Math.abs(a[i]) % 2 == Math.abs(a[i - 1]) % 2) {
				
				sum = 0L;
				previous_substraction = 0L;
				
			}
			
			sum += a[i];
			
			maximum_sum = Math.max(maximum_sum, sum - previous_substraction);
			
			previous_substraction = Math.min(previous_substraction, sum);
			
		}
		
		System.out.println(maximum_sum);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}