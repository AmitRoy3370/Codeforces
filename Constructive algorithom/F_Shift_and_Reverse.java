import java.util.Scanner;

public class F_Shift_and_Reverse {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	private static long solve(int reverse_operation) {
		
		int count = 0;
		int dismatch_index = -1;
		
		for(int i = 0; i != n - 1; ++i) {
			
			if(a[i] > a[i + 1]) {
				
				if(count > 0) {
					
					return (long)(1e9);
					
				}
				
				++count;
				dismatch_index = i + 1;
				
			}
			
		}
		
		if(a[n - 1] > a[0]) {
			
			if(count > 0) {
				
				return (long)(1e9);
				
			}
			
		}
		
		return Math.min(n - dismatch_index + reverse_operation, dismatch_index + 2 - reverse_operation);
		
	}
	
	static void solve() {
		
		// we need to find the bast case
		
		if(sorted(a)) {
			
			System.out.println(0);
			return;
			
		}
		
		long ans = solve(0);
		
		reverse(a);
		
		if(sorted(a)) {
			
			System.out.println(1);
			return;
			
		}
		
		ans = Math.min(ans, solve(1));
		
		if(ans == (long)(1e9)) {
			
			System.out.println(-1);
			
		} else {
			
			System.out.println(ans);
			
		}
		
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
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static boolean sorted(long a[]) {
		
		int n = a.length;
		
		for(int i = 1; i != n; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	private static boolean reverse_Sorted(long a[]) {
		
		int n = a.length;
		
		for(int i = n - 2; i >= 0; --i) {
			
			if(a[i] > a[i + 1]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	private static void reverse(long a[]) {
		
		int n = a.length;
		
		for(int i = 0; i != n / 2; ++i) {
			
			swap(a, i, n - i - 1);
			
		}
		
	}
	
	private static void swap(long a[], int i, int j) {
		
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
}