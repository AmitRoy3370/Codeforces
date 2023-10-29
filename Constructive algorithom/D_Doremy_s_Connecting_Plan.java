import java.util.Scanner;

public class D_Doremy_s_Connecting_Plan {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long k;
	
	static long a[];
	
	static void solve() {
		
		long prefix[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		int current_city = 1;
		
		for(int i = 2; i <= n; ++i) {
			
			if(prefix[current_city] + a[i] >= i * k) {
				
				current_city = i;
				
			}
			
		}
		
		if(current_city == n) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		k = in.nextLong();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}