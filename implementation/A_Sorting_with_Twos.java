import java.util.Scanner;

public class A_Sorting_with_Twos {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		boolean yes = true;
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(a[i] > a[i + 1]) {
				
				int index = i + 1;
				
				if(Math.floor(Math.log((double)index) / Math.log(2.0))  == Math.ceil(Math.log((double)index) / Math.log(2.0))) {
					
					yes = true;
					
				} else {
					
					yes = false;
					break;
					
				}
				
			}
			
		}
		
		if(yes) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}