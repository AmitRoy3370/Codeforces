import java.util.Scanner;

public class B_Indivisible {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println(1);
			
		} else if(n % 2 == 1) {
			
			System.out.println(-1);
			
		} else {
			
			int a[] = new int[n + 1];
			
			for(int i = 1; i <= n - 1; i += 2) {
				
				a[i + 1] = i;
				
			}
			
			for(int i = 2; i <= n; i += 2) {
				
				a[i - 1] = i;
				
			}
			
			for(int i = 1; i <= n; ++i) {
				
				System.out.print(a[i] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			solve();
			
		}
		
	}
	
}