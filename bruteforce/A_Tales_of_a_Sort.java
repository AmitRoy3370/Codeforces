import java.util.Scanner;

public class A_Tales_of_a_Sort {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		boolean already_sorted = true;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				already_sorted = false;
				break;
				
			}
			
		}
		
		if(already_sorted) {
			
			System.out.println(0);
			return;
			
		}
		
		long operations = 0L;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] < a[i - 1]) {
				
				operations = Math.max(a[i - 1], operations);
				
			}
			
		}
		
		System.out.println(operations);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}