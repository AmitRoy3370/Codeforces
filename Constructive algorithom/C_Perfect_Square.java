import java.util.Scanner;

public class C_Perfect_Square {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char mat[][];
	
	static char ch[] = {'a', 'b', 'c',
	'd', 'e', 'f', 'g', 'h', 'i', 'j', 
	'k', 'l', 'm', 'n', 'o', 'p', 'q',
	'r', 's', 't', 'u', 'v', 'w', 'x',
	'y', 'z'};
	
	static void solve() {
		
		long operations = 0L;
		
		for(int i = 0; i < n / 2; ++i) {
			
			for(int j = 0; j < n / 2; ++j) {
				
				int upper_left = (mat[i][j] - 'a');
				int upper_right = (mat[n - 1 - j][i] - 'a');
				int lower_left = (mat[j][n - i - 1] - 'a');
				int lower_right = (mat[n - i - 1][n - j - 1] - 'a');
				
				int max = Math.max(Math.max(upper_left, upper_right), Math.max(lower_left, lower_right));
				
				operations += (max - upper_left);
				operations += (max - upper_right);
				operations += (max - lower_left);
				operations += (max - lower_right);
			}
			
		}
		
		System.out.println(operations);
		
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
		
		mat = new char[n][n];
		
		for(int i = 0; i < n; ++i) {
			
			mat[i] = in.next().toCharArray();
			
		}
		
	}
}