import java.util.Scanner;

public class A_Cut_the_Triangle {
	
	static Scanner in = new Scanner(System.in);
	
	static long x[], y[];
	
	static int testCases;
	
	static void solve() {
		
		if(x[0] != x[1] && x[1] != x[2] && x[0] != x[2]) {
			
			System.out.println("YES");
			return;
			
		}
		
		if(y[0] != y[1] && y[1] != y[2] && y[0] != y[2]) {
			
			System.out.println("YES");
			return;
			
		}
		
		System.out.println("NO");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			x = new long[3];
			y = new long[3];
			
			for(int i = 0; i < 3; ++i) {
				
				x[i] = in.nextLong();
				y[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}