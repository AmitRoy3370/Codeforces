import java.util.Scanner;

public class B_Sort_with_Step {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		int dismatch = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(Math.abs(a[i] - i - 1) % k == 0) {
				
				continue;
				
			}
			
			++dismatch;
			
		}
		
		if(dismatch == 0) {
			
			System.out.println(0);
			
		} else {
			
			if(dismatch <= 2) {
				
				System.out.println(1);
				
			} else {
				
				System.out.println(-1);
				
			}
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}