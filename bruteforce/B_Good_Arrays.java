import java.util.Scanner;

public class B_Good_Arrays {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println("NO");
			return;
			
		}
		
		int one = 0;
		
		long sum = 0L;
		
		for(long i : a) {
			
			if(i == 1) {
				
				++one;
				
			}
			
			sum += i;
			
		}
		
		if(sum < one + n ) {
			
			System.out.println("NO");
			return;
			
		}
		
		System.out.println("YES");
		
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