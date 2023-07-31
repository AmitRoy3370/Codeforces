import java.util.Scanner;

public class A_Dalton_the_Teacher {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		int un_happy = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == i + 1) {
				
				++un_happy;
				
			}
			
		}
		
		int operation = (un_happy + 1) / 2;
		
		System.out.println(operation);
		
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
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}