import java.util.Scanner;

public class B_StORage_room {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[][];
	
	static void solve() {
		
		long ans[] = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			ans[i] = pow(2L, 30L, 1L) - 1L;
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			for(int j = 0; j != n; ++j) {
				
				if(i == j) {
					
					continue;
					
				}
				
				ans[i] &= a[i][j];
				ans[j] &= a[i][j];
				
			}
			
		}
		
		boolean yes = true;
		
		for(int i = 0; i != n; ++i) {
			
			for(int j = 0; j != n; ++j) {
				
				if(i == j) {
					
					continue;
					
				}
				
				if((ans[i] | ans[j]) != a[i][j]) {
					
					yes = false;
					break;
					
				}
				
			}
			
			if(!yes) {
				
				break;
				
			}
			
		}
		
		if(yes) {
			
			System.out.println("YES");
			
			for(long i : ans) {
				
				System.out.print(i + " ");
				
			}
			
			System.out.println();
			
		} else {
			
			System.out.println("NO");
			
		}
		
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
		
		a = new long[n][n];
		
		for(int i = 0; i != n; ++i) {
			
			for(int j = 0; j != n; ++j) {
				
				a[i][j] = in.nextLong();
				
			}
			
		}
		
	}
	
	private static long pow(long base, long power, long value) {
		
		if(power == 0L) {
			
			return 1L;
			
		}
		
		value = pow(base, power / 2L, value);
		
		if(power % 2L == 1L) {
			
			return value * value * base;
			
		} else {
			
			return value * value;
			
		}
		
	} 
	
}