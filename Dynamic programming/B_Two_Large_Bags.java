import java.util.Scanner;

public class B_Two_Large_Bags {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static void solve() {
		
		int dpCount[] = new int[n + 2];
		
		for(int i : a) {
			
			dpCount[i]++;
			
		}
		
		for(int i = 1; i <= n; ++i) {
			
			if(dpCount[i] == 1) {
				
				System.out.println("NO");
				return;
				
			}
			
			if(dpCount[i] == 0) {
				
				continue;
				
			}
			
			dpCount[i]--;
			dpCount[i + 1] += dpCount[i] - 1;
			
		}
		
		System.out.println("YES");
		
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