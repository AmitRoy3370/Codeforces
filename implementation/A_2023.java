import java.util.Scanner;

public class A_2023 {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		long mul = 1L;
		
		for(long i : a) {
			
			mul *= i;
			
		}
		
		if(2023L % mul != 0) {
			
			System.out.println("NO");
			
		} else {
			
			System.out.println("YES");
			
			System.out.print((2023L / mul) + " ");
			
			System.out.println("1 ".repeat(k -1));
			
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
		
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}