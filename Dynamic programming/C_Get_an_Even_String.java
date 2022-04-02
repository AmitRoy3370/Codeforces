import java.util.Scanner;

public class C_Get_an_Even_String {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		int dp[] = new int[n + 1];
		
		int position[] = new int[256];
		
		for(int i = 0; i < 256; ++i) {
			
			position[i] = -1;
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			int last_seen = position[a[i - 1]];
			
			if(last_seen == -1) {
				
				dp[i] = dp[i - 1] + 1;
				
			} else {
				
				int choice1 = dp[i - 1] + 1;
				
				int choice2 = (i - last_seen - 1) + dp[last_seen - 1];
				
				dp[i] = Math.min(choice1, choice2);
				
			}
			
			position[a[i - 1]] = i;
			
		}
		
		System.out.println(dp[n]);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.next().toCharArray();
			
			n = a.length;
			
			solve();
			
		}
		
	}
	
}