import java.util.Scanner;

public class B_Not_Dividing {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == 1L) {
				
				++a[i];
				
			}
			
		}
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] % a[i - 1] == 0L) {
				
				++a[i];
				
			}
			
		}
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
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