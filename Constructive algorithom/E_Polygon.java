import java.util.Scanner;

public class E_Polygon {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, n;
	
	private static char a[][];
	
	private static void solve() {
		
		boolean ok = true;
		
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				if(i + 1 < n && j + 1 < n) {
					
					if(a[i][j] == '1' && a[i + 1][j] == '0' && a[i][j + 1] == '0' ) {
						
						ok = false;
						
						break;
						
					}
					
				}
				
			}
			
			if(!ok) {
				
				break;
				
			}
			
		}
		
		if(ok) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new char[n][n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.next().toCharArray();
				
			}
			
			solve();
			
		}
		
	}
	
}