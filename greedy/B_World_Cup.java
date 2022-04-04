import java.util.Scanner;

public class B_World_Cup {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static void solve() {
		
		long b[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = a[i];
			
			b[i] = Math.max(0, b[i] - i);
			
			b[i] = (b[i] / n) + ((b[i] % n) >= 1 ? 1 : 0);
			
		}
		
		int path = 0;
		
		long max = Long.MAX_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			if(max > b[i] ) {
				
				max = b[i];
				
				path = i + 1;
				
			}
			
		}
		
		//++path;
		
		System.out.print(path);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		 
		solve();
		
	}
	
}