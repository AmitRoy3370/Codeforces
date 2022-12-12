import java.util.Scanner;

public class A_Hossam_and_Combinatorics {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, a[];
	
	static void solve() {
		
		int max = a[0];
		int min = a[0];
		
		for(int i : a) {
			
			max = Math.max(i, max);
			min = Math.min(i, min);
			
		}
		
		long count_max = 0, count_min = 0;
		
		for(int i : a) {
			
			if(i == max) {
				
				++count_max;
				
			} else if(i == min) {
				
				++count_min;
				
			}
			
		}
		
		if(max == min) {
			
			long ans = (long)n * (long)(n - 1);
			
			System.out.println(ans);
			
		} else {
			
			long ans = 2 * count_max * count_min;
			
			System.out.println(ans);
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}