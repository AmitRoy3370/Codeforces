import java.util.Scanner;

public class C_Round_Table_Knights {
	
	static int n;
	
	static int a[];
	
	static Scanner in = new Scanner(System.in);
	
	static long dp[];
	
	/*
	
	given data:
	............
	
	Here we have a binary array of length n.
	where 1 means active point and 0 means deactive.
	
	main requirement's:
	...................
	
	here we have to build a polygon with the active 
    point's. The polygon is the figure where the
    minimum 3 arm's are equal and all the angle are
    equal.	
	
	solve example:
	..............
	
	3
	1	1	1
	
	here we can build a triangle from this figure.
	
	6
	1	0	1	1	1	0
	
	here we can build a triangle with the 3,4 and 5
	th point.
	
	6
	1	0	0	1	0	1
	
	here we can not build any polygon from this 
	system.
	
	observations:
	.............
	
	* here we have at least 3 active point in a raw.
	* or atleast 3 active point have same distance.
	
	*/
	
	static boolean solve(int distance) {
		
		if(n / distance < 3) {
			
			return false;
			
		}
		
		for(int i = 0; i <= n; ++i) {
			
			if(a[i] == 0) {
				
				dp[i] = 0L;
				
			} else {
				
				if(i - distance >= 0) {
					
					dp[i] = dp[i - distance] + 1L;
					
				} else {
					
					dp[i] = 1L;
					
				}
				
			}
			
			if(dp[i] == n / distance) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	static void solve() {
		
		for(int partical = 1; partical <= (int)Math.sqrt(n); ++partical) {
			
			if(n % partical != 0) {
				
				continue;
				
			}
			
			if(solve(partical) || solve(n / partical)) {
				
				System.out.println("YES");
				return;
				
			}
			
		}
		
		System.out.println("NO");
		
				
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		dp = new long[n + 1];
		
		a = new int[n + 1];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		} 
		
		solve();
		
	}
	
}