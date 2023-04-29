import java.util.Scanner;

public class A_A_characteristic {
	
	static int testCases, n, k;
	
	static Scanner in = new Scanner(System.in);
	
	static void solve() {
		
		if(k == 0) {
			
			if(n > 2) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		if(n == 2) {
			
			if(k == 0) {
				
				System.out.println("YES");
				
				System.out.println(1 + " " + -1);
				return;
				
			}
			
			if(k == 1) {
				
				System.out.println("YES");
				
				System.out.println(1 + " " + 1);
				return;
				
			}
			
		}
		
		int b[] = new int[n + 1];
		
		int expected_index = -1;
		
		for(int i = 1; i <= n; ++i) {
			
			int neg = (i * (i - 1)) / 2;
			
			int pos = ((n - i) * (n - i - 1)) / 2;
			
			if(pos + neg == k) {
				
				expected_index = i;
				break;
				
			}
			
		}
		
		for(int i = 1; i <= expected_index; ++i) {
			
			b[i] = -1;
			
		}
		
		for(int i = expected_index + 1; i <= n; ++i) {
			
			b[i] = 1;
			
		}
		
		if(expected_index == -1) {
			
			System.out.println("NO");
			return;
			
		}
		
		System.out.println("YES");
		
		for(int i = 1; i <= n; ++i) {
			
			System.out.print(b[i] + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			k = in.nextInt();
			
			solve();
			
		}
		
	}
	
}