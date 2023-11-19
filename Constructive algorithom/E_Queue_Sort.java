import java.util.Scanner;

public class E_Queue_Sort {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int min_index = 0;
		
		for(int i = 1; i != n; ++i) {
			
			if(a[min_index] > a[i]) {
				
				min_index = i;
				
			}
			
		}
		
		for(int i = min_index + 1; i != n; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				System.out.println(-1);
				return;
				
			}
			
		}
		
		System.out.println(min_index);
		
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