import java.util.Scanner;

public class B_Fibonaccharsis {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long k;
	
	static void solve() {
		
		if(k >= 30L) {
			
			System.out.println(0);
			return;
			
		}
		
		long second = n, first = 0;
		
		int way = 0;
		
		for(int i = 0; i <= n; ++i) {
			
			second = n;
			first = i;
			
			boolean ok = true;
			
			for(int j = 1; j <= k - 2; ++j) {
				
				long temp = second - first;
				
				second = first;
				first = temp;
				
				if(first > -1 && second >= first) {
					
					continue;
					
				}
				
				ok = false;
				
				break;
				
			}
			
			if(ok) {
				
				++way;
				
			}
			
		}
		
		System.out.println(way);
		
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
		
		k = in.nextLong();
		
	}
	
}