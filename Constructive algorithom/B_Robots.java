import java.util.Scanner;

public class B_Robots {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char a[][];
	
	static void solve() {
		
		int first_robot_x = -1, first_robot_y = -1;
		
		for(int j = 0; j < m; ++j) {
			
			boolean find = false;
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i][j] == 'R') {
					
					find = true;
					first_robot_x = i;
					first_robot_y = j;
					break;
					
				}
				
			}
			
			if(find)
				break;
			
		}
		
		for(int i = 0; i < first_robot_x; ++i) {
			
			for(int j = 0; j < m; ++j) {
				
				if(a[i][j] == 'R') {
					
					System.out.println("NO");
					return;
					
				}
				
			}
			
		}
		
		System.out.println("YES");
		
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