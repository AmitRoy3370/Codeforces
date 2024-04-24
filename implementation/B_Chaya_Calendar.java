import java.util.Scanner;

public class B_Chaya_Calendar {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long time = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			if(a[i] > time) {
				
				time = a[i];
				
			} else {
				
				long time1 = ( (time) / a[i]);
				
				time =  ++time1 * a[i];
				
			}
			
		}
		
		System.out.println(time);
		
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
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}