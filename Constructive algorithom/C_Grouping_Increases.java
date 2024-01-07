import java.util.Scanner;

public class C_Grouping_Increases {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int penalty = 0;
		
		long b[] = new long[2];
		
		b[0] = Long.MAX_VALUE;
		b[1] = Long.MAX_VALUE;
		
		for(int i = 0; i != n; ++i) {
			
			if(b[0] > b[1]) {
				
				long temp = b[0];
				b[0] = b[1];
				b[1] = temp;
				
			}
			
			if(b[0] >= a[i]) {
				
				b[0] = a[i];
				
			} else if(b[1] >= a[i]) {
				
				b[1] = a[i];
				
			} else {
				
				b[0] = a[i];
				++penalty;
				
			}
			
		}
		
		System.out.println(penalty);
		
	}
	
	public static void main(String [] amit) {
		
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