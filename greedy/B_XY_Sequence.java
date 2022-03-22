import java.util.Scanner;

public class B_XY_Sequence {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases, B;
	
	static long x, y;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		long dp[] = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			if(dp[i - 1] + x <= B){
               
			   dp[i] = dp[i - 1] + x;
            
			}else{
            
			   dp[i] = dp[i - 1] - y;
            
			}
			
		}
		
		long sum = 0;
		
		for(long i : dp) {
			
			sum += i;
			
		}
		
		ans.append(sum).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			B = in.nextInt();
			
			x = in.nextLong();
			
			y = in.nextLong();
			
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
}