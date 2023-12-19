import java.util.Scanner;

public class B_Swap_and_Delete {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println(1);
			return;
			
		}
		
		int count[] = new int[2];
		
		for(char i : x) {
			
			count[i - '0']++;
			
		}
		
		if(count[0] == n || count[1] == n) {
			
			System.out.println(n);
			
		} else if(count[0] == count[1]) {
			
			System.out.println(0);
			
		} else {
			
			int i = 0;
			
			for(; i != n; ++i) {
				
				if(x[i] == '1') {
					
					if(count[0] > 0) {
						
						--count[0];
						
					} else {
						
						break;
						
					}
					
				} else {
					
					if(count[1] > 0) {
						
						--count[1];
						
					} else {
						
						break;
						
					}
					
				}
				
			}
			
			int cost = n - i;
			
			System.out.println(cost);
			
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
		
		x = in.next().toCharArray();
		
		n = x.length;
		
	}
	
}