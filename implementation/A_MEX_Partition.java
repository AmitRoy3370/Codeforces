import java.util.Scanner;

public class A_MEX_Partition {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		int count[] = new int[101];
		
		for(int i : a) {
			
			count[i]++;
			
		}
		
		for(int i = 0; i <= n + 1; ++i) {
			
			if(count[i] == 0) {
				
				System.out.println(i);
				return;
				
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	public static void main(String [] Priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}