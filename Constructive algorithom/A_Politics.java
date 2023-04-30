import java.util.Scanner;

public class A_Politics {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char a[][];
	
	static void solve() {
		
		int member = n;
		
		int deduct = 0;
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < m; ++j) {
				
				if(a[0][j] != a[i][j]) {
					
					++deduct;
					break;
					
				}
				
			}
			
		}
		
		member -= deduct;
		
		System.out.println(member);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			a = new char[n][m];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.next().toCharArray();
				
			}
			
			solve();
			
		}
		
	}
	
}