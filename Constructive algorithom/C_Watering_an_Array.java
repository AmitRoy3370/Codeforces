import java.util.Scanner;

public class C_Watering_an_Array {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	static long d;
	
	static long a[], b[], c[];
	
	static void solve() {
		
		long score = 0L;
		
		for(int first_type = 0; first_type != Math.min(2 * n + 1, d); ++first_type) {
			
			int day = first_type % k;
			
			int total_match = 0;
			
			for(int i = 0; i != n; ++i) {
				
				if(a[i] == i + 1) {
					
					++total_match;
					
				}
				
			}
			
			score = Math.max(score, total_match + (d - first_type - 1) / 2L);
			
			for(int i = 1; i != b[day] + 1; ++i) {
				
				a[i - 1]++;
				
			}
			
		}
		
		System.out.println(score);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		d = in.nextLong();
		
		a = new long[n];
		b = new long[k];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != k; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}