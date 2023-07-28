import java.util.Scanner;

public class D_Array_Painting {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		int moves = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(i - 1 >= 0 && a[i - 1] != 0) {
				
				a[i - 1]--;
				
			} else if(i + 1 < n && a[i + 1] != 0 && a[i] == 0) {
				
				a[i + 1]--;
				
			} else {
				
				++moves;
				
			}
			
		}
		
		System.out.println(moves);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}