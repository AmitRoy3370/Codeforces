import java.util.Scanner;

public class B_Farewell_Party {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[];
	
	static void solve() {
		
		int element[] = new int[n + 1];
		
		for(int i : a) {
			
			element[i]++;
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			if(element[i] % (n - i) != 0 ) {
				
				System.out.print("Impossible");
				return;
				
			}
			
		}
		
		System.out.println("Possible");
		
		int dp[] = new int[n];
		
		int counter = 1;
		
		for(int i = 0; i < n; ++i) {
			
			if(dp[i] == 0) {
			
			 int place = n - a[i];
			
			 for(int j = i; j < n && place > 0; ++j) {
				
				if(a[i] == a[j]) {
					
					dp[j] = counter;
					--place;
					
				}
				
			 }
			
			 ++counter;
			
			}
			
		}
		
		for(int i : dp) {
			
			System.out.print(i + " ");
			
		} 
		
	} 
	
	public static void main (String [] amit) {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}