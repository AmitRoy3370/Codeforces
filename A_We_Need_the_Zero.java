import java.util.Scanner;

public class A_We_Need_the_Zero {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long xor = 0L;
		
		int index = 0;
		
		for(long i : a) {
			
			xor ^= i;
			
			++index;
			
		}
		
		if(xor == 0L) {
			
			System.out.println(0);
			
		} else {
			
			if(n % 2 == 1) {
				
				System.out.println(xor);
				
			} else {
				
				System.out.println(-1);
				
			}
			
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