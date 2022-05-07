import java.util.Scanner;

public class A_Prof_Slim {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static long a[];
	
	static void solve() {
		
		int neg = 0;
		
		for(long i : a) {
			
			if(i < 0) {
				
				++neg;
				
			}
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = Math.abs(a[i]);
			
		}
 		
		for(int i = 0; i < neg; ++i) {
			
			a[i] *= -1;
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			if(i + 1 < n && a[i] > a[i + 1]) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		System.out.println("YES");
		
	}
	
	public static void main(String [] amit) {
		
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