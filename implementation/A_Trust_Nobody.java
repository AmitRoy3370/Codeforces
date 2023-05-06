import java.util.Scanner;

public class A_Trust_Nobody {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		int liars = -1;
		
		for(int x = 0; x <= n; ++x) {
			
			int almost_liars = 0;
			
			for(int i : a) {
				
				if(i > x) {
					
					++almost_liars;
					
				}
				
			}
			
			if(almost_liars == x) {
				
				liars = x;
				
			}
			
		}
		
		System.out.println(liars);
		
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
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}