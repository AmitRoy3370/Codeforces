import java.util.Scanner;

public class C_Another_Permutation_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static void solve() {
		
		long max_value = 0L;
		
		for(int i = n - 1; i > -2; --i) {
			
			long left = 0L, start = 1, last = n, max = 1L, count = 1;
			
			for(int j = 0; j < i + 1; ++j) {
				
				left += start * count;
				
				max = Math.max(max, start * count);
				
				++start;
				++count;
				
			}
			
			for(int j = i + 1; j < n; ++j) {
				
				left += last * count;
				
				max = Math.max(max, last * count);
				
				++count;
				--last;
				
			}
			
			max_value = Math.max(max_value, left - max);
			
		}
		
		System.out.println(max_value);
		
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
		
	}
	
}