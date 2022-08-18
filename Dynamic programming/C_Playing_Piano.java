import java.util.Scanner;

public class C_Playing_Piano {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[], b[];
	
	/*
	
	* 1 1 4 2 2
	
	- 1 2 3 2 1 : b
	
	* 1 5 7 8 10 3 1
	
	- 1 2 3 4 5  4 3 : b
	
	* 3 3 7 9 8 8 8 8 7 7 7 7 5 3 3 3 3 8 8
	
	- 2 1 2 3 1 2 1 2 1 2 1 2 3 2 1 2 1 2 1 : b
	 
	- 1 5 7 8 10 3 1
	 
	   0  1  2 3  4  5  6
    -|--|--|--|--|--|--|--|- 	  
	0| 1| 1| 1| 1| 1| 1| 1|- -> initially all bit we set 1
	-|--|--|--|--|--|--|--|-
	1| 0| 0| 1| 1| 1| 1| 1|	
	-|--|--|--|--|--|--|--|-
	2| 0| 0| 0| 2| 2| 2| 2|
	-|--|--|--|--|--|--|--|-
	3| 0| 0| 0| 0| 3| 3| 3|
	-|--|--|--|--|--|--|--|-
	4| 0| 0| 0| 0| 0| 4| 4|
	-|--|--|--|--|--|--|--|-
	5| 0| 5| 5| 5| 5| 0| 0|
	-|--|--|--|--|--|--|--|-
	6| 0| 2| 3| 4| 0| 0| 0|
	-|--|--|--|--|--|--|--|-
	
	*/
	
	static void solve() {
		
		int dp[][] = new int[n][6];
		
		for(int i = 0; i < 6; ++i) {
			
			dp[0][i] = 1;
			
		}
		
		for(int i = 1; i < n; ++i) {
			
			for(int j = 1; j < 6; ++j) {
				
				for(int k = 1; k < 6; ++k) {
					
					if(dp[i - 1][k] == 0) {
						
						continue;
						
					}
					
					if(a[i] > a[i - 1] && j > k) {
						
						dp[i][j] = k;
						break;
						
					} else if(a[i] < a[i - 1] && j < k) {
						
						dp[i][j] = k;
						break;
						
					} else if(a[i] == a[i - 1] && j != k) {
						
						dp[i][j] = k;
						break;
						
					}
					
				}
				
			}
			
		}
		
		//print(dp);
		
		int start = 0;
		
		for(int i = 1; i < 6; ++i) {
			
			if(dp[n - 1][i] > 0) {
				
				start = i;
				break;
				
			}
			
		}
		
		if(start == 0) {
			
			System.out.print(-1);
			return;
			
		}
		
		for(int i = n - 1; i >= 0; --i) {
			
			//start = dp[n - 1][i];
			
			b[i] = start;
			
			if(i > 0) {
				
				start = dp[i][start];
				
			}
			
		}
		
		for(int i : b) {
			
			System.out.print(i + " ");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new int[n];
		b = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
	static void print(int dp[][]) {
		
		for(int i[] : dp) {
			
			for(int j : i) {
				
				System.out.print(j + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
}