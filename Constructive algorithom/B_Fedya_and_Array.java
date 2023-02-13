import java.util.Scanner;

public class B_Fedya_and_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, a, b;
	
	static void solve() {
		
		int n = 2 * (a - b);
		
		System.out.println(n);
		
		for(int i = b; i <= a; ++i) {
			
			System.out.print(i + " ");
			
		}
		
		for(int i = a - 1; i > b; --i) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.nextInt();
			b = in.nextInt();
			
			solve();
			
		}
		
	}
	
}