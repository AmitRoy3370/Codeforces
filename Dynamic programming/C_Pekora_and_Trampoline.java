import java.util.Scanner;

public class C_Pekora_and_Trampoline {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCasees, n;
	
	static int a[];
	
	static void solve(int t) {
		
		long dp[] = new long[n + 1];
		
		long answer = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] <= 1) { // if array has already 1 then no need to change that element
				
				dp[i + 1] += dp[i]; // update the last last element of the dp array 
				
				continue;
				
			}
			
			for(int j = 2; j <= a[i]; ++j) { // every element will be minimize to 1, we will count for every changes what element will be updated
				
				if(i + j >= n) {
					
					break;
					
				}
				
				dp[i + j]++; // count the jumping element changes 
				
			}
			
			if(a[i] > dp[i]) {
				
				a[i] -= dp[i];
				
				answer += (a[i] - 1);
				
			} else {
				
				dp[i] = (dp[i] - (a[i] - 1)); // a[i] elements number f time the task run
				
				a[i] = 1; // a[i] will be the 1
				
				dp[i + 1] += dp[i]; // update the next counting as the prefix as we will count the total way till ith position
				
			}
			
		}
		
		System.out.print(answer);
		
		if(t != testCasees) {
			
			System.out.println();
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCasees = in.nextInt();
		
		for(int t = 0; t < testCasees; ++t) {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve(t + 1);
			
		}
		
	}
	
}