import java.util.Scanner;

public class B_Three_Threadlets {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long A, B, C;
	
	static int operations = 0;
	
	static boolean equally_distributed(long x, long min) {
		
		if(x <= min) {
			
			return true;
			
		}
		
		++operations;
		
		if(operations > 3 || x % min != 0) {
			
			return false;
			
		}
		
		x -= min;
		
		return equally_distributed(x, min);
		
	}
	
	static void solve() {
		
		long min = Math.min(Math.min(A, B), C);
		
		boolean yes = true;
		
		operations = 0;
		
		if(A % min != 0 || B % min != 0 || C % min != 0) {
			
			yes = false;
			
		}
		
		yes = equally_distributed(A, min) & yes;
		yes = equally_distributed(B, min) & yes;
		yes = equally_distributed(C, min) & yes;
		
		if(operations > 3) {
			
			yes = false;
			
		}
		
		if(yes) {
			
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
		
		A = in.nextLong();
		B = in.nextLong();
		C = in.nextLong();
	}
	
}