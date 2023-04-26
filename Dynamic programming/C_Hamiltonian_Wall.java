import java.util.Scanner;

public class C_Hamiltonian_Wall {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[][];
	
	static boolean solve(int i, int j) {
		
		if(j == n) {
			
			return true;
			
		}
		
		if(a[i][j] == 'W') {
			
			return false;
			
		}
		
		if(a[1 - i][j] == 'B') {
			
			return solve(1 - i, j + 1);
			
		}
		
		return solve(i, j + 1);
		
	}
	
	static void solve() {
		
		if(solve(0, 0) || solve(1, 0)) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new char[2][n];
			
			for(int i = 0; i < 2; ++i) {
				
				a[i] = in.next().toCharArray();
				
			}
			
			solve();
			
		} 
		
	}
	
}