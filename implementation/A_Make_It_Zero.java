import java.util.Scanner;

public class A_Make_It_Zero {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(n % 2 == 0) {
			
			System.out.println(2);
			
			System.out.println(1 + " " + n);
			System.out.println(1 + " " + n);
			
		} else {
			
			System.out.println(4);
			
			System.out.println(1 + " " + (n - 1));
			System.out.println(1 + " " + (n - 1));
			System.out.println((n - 1) + " " + n);
			System.out.println((n - 1) + " " + n);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}