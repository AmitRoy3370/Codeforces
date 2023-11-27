import java.util.Scanner;

public class B_Laura_and_Operations {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(a[1] % 2L == a[2] % 2L) {
			
			System.out.print(1 + " ");
			
		} else {
			
			System.out.print(0 + " ");
			
		}
		
		if(a[0] % 2L == a[2] % 2L) {
			
			System.out.print(1 + " ");
			
		} else {
			
			System.out.print(0 + " ");
			
		}
		
		if(a[0] % 2L == a[1] % 2L) {
			
			System.out.print(1 + " ");
			
		} else {
			
			System.out.print(0 + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = 3;
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}