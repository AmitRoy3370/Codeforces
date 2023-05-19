import java.util.Scanner;

public class C_Contrast_Value {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long sum = 0L;
		
		for(int i = 0; i < n - 1; ++i) {
			
			sum += Math.abs(a[i] - a[i + 1]);
			
		}
		
		if(sum == 0L) {
			
			System.out.println(1);
			return;
			
		}
		
		int length = unique(a);
		
		for(int i = 0; i < n - 2; ++i) {
			
			if(a[i] < a[i + 1] && a[i + 1] < a[i + 2]) {
				
				--length;
				
			}
			
			if(a[i + 1] < a[i] && a[i + 1] > a[i + 2] ) {
				
				--length;
				
			}
			
		}
		
		System.out.println(length);
		
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
	
	private static int unique(long a[]) {
		
		int j = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(i == n - 1 || a[i] != a[i + 1]) {
				
				a[j++] = a[i];
				
			}
			
		}
		
		n = j;
		
		return j;
		
	}
	
}