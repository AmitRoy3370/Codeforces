import java.util.Scanner;

public class B_Qingshan_Loves_Strings {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char x[], y[];
	
	static void solve() {
		
		boolean first_ok = true;
		boolean second_ok = true;
		
		boolean one = false;
		boolean zero = false;
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(x[i] == x[i + 1]) {
				
				first_ok = false;
				
				if(x[i] == '1') {
					
					one = true;
					
				} else {
					
					zero = true;
					
				}
				
			}
			
		}
		
		for(int i = 0; i < m - 1; ++i) {
			
			if(y[i] == y[i + 1]) {
				
				second_ok = false;
				break;
				
			}
			
		}
		
		if(first_ok) {
			
			System.out.println("YES");
			
		} else {
			
			if(!second_ok || (one && zero)) {
				
				System.out.println("NO");
				
			} else {
				
				if(one) {
					
					if(y[0] == y[m - 1] && y[0] == '0') {
						
						System.out.println("YES");
						
					} else {
						
						System.out.println("NO");
						
					}
					
				} else {
					
					if(y[0] == y[m - 1] && y[0] == '1') {
						
						System.out.println("YES");
						
					} else {
						
						System.out.println("NO");
						
					}
					
				}
				
			}
			
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
		
		n = in.nextInt();
		m = in.nextInt();
		
		x = in.next().toCharArray();
		y = in.next().toCharArray();
		
	}
	
}