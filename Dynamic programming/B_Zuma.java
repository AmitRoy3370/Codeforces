import java.util.Scanner;

public class B_Zuma {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[];
	
	static void solve() {
		
		boolean already_palindrome = true;
		
		//check that the number is already palindrome or not, if yes, then we need only one operation.
		
		for(int i = 1; i <= n / 2; ++i) {
			
			if(a[i] != a[n - i + 1]) {
				
				already_palindrome = false;
				break;
				
			}
			
		} 
		
		if(already_palindrome) {
			
			System.out.println(1);
			return;
			
		}
		
		int dp[][] = new int[n + 2][n + 2];
		
		for(int i = n; i >= 1; --i) {
			
			for(int j = i; j <= n; ++j) {
				
				if(i == j) {
					
					dp[i][j] = 1;
					continue;
					
				}
				
				// guess that we delete the present one as a palindrome.
				
				dp[i][j] = dp[i + 1][j] + 1;
				
				// if the consecutive two are same, then delete the two pair from the list.
				
				if(a[i] == a[i + 1]) {
					
					dp[i][j] = Math.min(dp[i][j], dp[i + 2][j] + 1);
					
				}
				
				for(int k = i + 2; k <= j; ++k) {
					
					if(a[i] == a[k]) {
						
						/*
						
						other wise for any equal pair 
						b/w i + 2 to j, check that their
						middle portion means, that i to 
						k - 1 have how many palindrome pair,
						as here the length is too more. So,
						we will check that already we remove
						the palindrome sequence among them or not.
						so, collect that result first to our answer.
						then add it with the newxt portion's. means
						that k + 1 to j. So, finally we get the portion
						i to j.
						
						*/
						
						dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j]);
						
					}
					
				}
				
			}
			
		}
		
		System.out.println(dp[1][n]);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}