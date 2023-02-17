import java.util.Scanner;

public class A_Two_Towers {
	
	static Scanner in = new Scanner(System.in);
	
	static char a[], b[];
	
	static int m, n, testCases;
	
	static void solve() {
		
		int total_invalid_two_block = 0;
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(a[i] == a[i + 1]) {
				
				++total_invalid_two_block;
				
			}
			
		}
		
		for(int i = 0; i < m - 1; ++i) {
			
			if(b[i] == b[i + 1]) {
				
				++total_invalid_two_block;
				
			}
			
		}
		
		if(total_invalid_two_block > 1) {
			
			System.out.println("NO");
			
		} else if(total_invalid_two_block == 1) {
			
			if(a[n - 1] == b[m - 1]) {
				
				System.out.println("NO");
				
			} else {
				
				System.out.println("YES");
				
			}
			
		} else {
			
			System.out.println("YES");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			m = in.nextInt();
			
			a = in.next().toCharArray();
			b = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}