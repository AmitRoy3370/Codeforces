import java.util.Scanner;

public class A_Desorting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		boolean already_sorted = true;
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				already_sorted = false;
				break;
				
			}
			
		}
		
		if(!already_sorted) {
			
			System.out.println(0);
			return;
			
		}
		
		long min_difference = Long.MAX_VALUE;
		
		for(int i = 1; i < n; ++i) {
			
			min_difference = Math.min(min_difference, a[i] - a[i - 1]);
			
		}
		
		long step = min_difference / 2L + 1L;
		
		System.out.println(step);
		
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