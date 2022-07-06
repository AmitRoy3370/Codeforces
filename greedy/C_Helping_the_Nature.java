import java.util.Scanner;

public class C_Helping_the_Nature {
	
	static int testCases, n;
	
	static long a[];
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		long height = a[0];
		
		long ans = 0;
		
		for(int i = 1; i < n; ++i) {
			
			long difference = a[i - 1] - a[i];
			
			ans += Math.abs(difference);
			
			if(difference > 0) {
				
				height -= difference;
				
			}
			
		}
		
		ans += Math.abs(height);
		
		System.out.println(ans);
		
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