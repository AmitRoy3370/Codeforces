import java.util.Scanner;

public class C_Ntarsis_Set {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		long smallest = 1L;
		
		int additional = 0;
		
		while(k-- > 0) {
			
			while(additional < n && a[additional] <= smallest + additional) {
				
				++additional;
				
			}
			
			smallest += additional;
			
		}
		
		System.out.println(smallest);
		
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
		
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i  < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}