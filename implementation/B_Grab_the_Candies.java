import java.util.Scanner;

public class B_Grab_the_Candies {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long even = 0L, odd = 0L;
		
		for(long i : a) {
			
			if(i % 2L == 0L) {
				
				even += i;
				
			} else {
				
				odd += i;
				
			}
			
		}
		
		if(even > odd) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}