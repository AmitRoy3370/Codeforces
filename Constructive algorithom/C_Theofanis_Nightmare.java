import java.util.Scanner;

public class C_Theofanis_Nightmare {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long suffix[] = new long[n];
		
		suffix[n - 1] = a[n - 1];
		
		for(int i = n - 2; i >= 0; --i) {
			
			suffix[i] = suffix[i + 1] + a[i];
			
		}
		
		long value = suffix[0];
		
		for(int i = 1; i < n; ++i) {
			
			if(suffix[i] > 0) {
				
				value += suffix[i];
				
			}
			
		}
		
		System.out.println(value);
		
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