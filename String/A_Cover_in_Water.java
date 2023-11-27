import java.util.Scanner;

public class A_Cover_in_Water {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int empty_cell = 0;
		boolean flag = false;
		
		int action_1 = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(x[i] == '.' && flag) {
				
				++empty_cell;
				++action_1;
				
			}
			
			if(empty_cell >= 3) {
				
				System.out.println(2);
				return;
				
			}
			
			if(x[i] == '.' && !flag) {
				
				++empty_cell;
				++action_1;
				flag = true;
				
			}
			
			if(x[i] != '.' && flag) {
				
				empty_cell = 0;
				flag = false;
				
			}
			
		}
		
		System.out.println(action_1);
		
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
		
		x = in.next().toCharArray();
		
	}
	
}