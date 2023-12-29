import java.util.Scanner;

public class B_Not_Quite_Latin_Square {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[][];
	
	static void solve() {
		
		boolean present[] = new boolean[3];
		
		int raw = -1;
		
		for(int i = 0; i != 3; ++i) {
			
			boolean find = false;
			
			for(int j = 0; j != 3; ++j) {
				
				if(x[i][j] == '?') {
					
					raw = i;
					find = true;
					break;
					
				}
				
			}
			
			if(find) {
				
				break;
				
			}
			
		}
		
		for(int i = 0; i != 3; ++i) {
			
			if(x[raw][i] == '?') {
				
				continue;
				
			}
			
			present[x[raw][i] - 'A'] = true;
			
		}
		
		char ch[] = new char[]{'A', 'B', 'C'};
		
		for(int i = 0; i != 3; ++i) {
			
			if(!present[i]) {
				
				System.out.println(ch[i]);
				return;
				
			}
			
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
		
		n = 3;
		
		x = new char[3][3];
		
		for(int i = 0; i != n; ++i) {
			
			x[i] = in.next().toCharArray();
			
		}
		
	}
	
}