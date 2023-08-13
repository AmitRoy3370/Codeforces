import java.util.Scanner;

public class B_Olya_and_Game_with_Arrays {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
		
		long sum = 0L;
		
		for(int i = 0; i < n; ++i) {
			
			int m = in.nextInt();
			
			a = new long[m];
			
			for(int j = 0; j < m; ++j) {
				
				a[j] = in.nextLong();
				
			}
			
			long min = Long.MAX_VALUE;
			
			int index = -1;
			
			for(int j = 0; j < m; ++j) {
				
				if(a[j] < min) {
					
					min = a[j];
					index = j;
					
				}
				
			}
			
			long second_min = Long.MAX_VALUE;
			
			for(int j = 0; j < m; ++j) {
				
				if(j == index) {
					
					continue;
					
				}
				
				second_min = Math.min(second_min, a[j]);
				
			}
			
			sum += second_min;
			
			min1 = Math.min(min, min1);
			
			min2 = Math.min(min2, second_min);
			
		}
		
		sum += min1 - min2;
		
		System.out.println(sum);
		
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