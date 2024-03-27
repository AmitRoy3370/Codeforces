import java.util.Scanner;

public class B_Milena_and_Admirer {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long operations = 0L;
		
		for(int i = n - 2; i >= 0; --i) {
			
			long operation = (a[i] - 1L) / a[i + 1] + 1L;
			
			operations += operation - 1L;
			
			a[i] /= operation;
			
		}
		
		System.out.println(operations);
		
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