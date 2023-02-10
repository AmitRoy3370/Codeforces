import java.util.Scanner;

public class A_One_and_Two {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int k = Integer.MAX_VALUE;
		
		boolean find = false;
		
		int two = 0;
		
		for(long i : a) {
			
			if(i == 2L) {
				
				++two;
				
			}
			
		}
		
		if(two % 2 == 1) {
			
			System.out.println(-1);
			return;
			
		}
		
		int now = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == 2L) {
				
				++now;
				
			}
			
			if(now == two / 2) {
				
				k = i + 1;
				
				find = true;
				
				break;
				
			}
			
		}
		
	    if(!find) {
			
			System.out.println(-1);
			
		} else {
			
			System.out.println(k);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
}