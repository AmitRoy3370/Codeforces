import java.util.Scanner;

public class A_Yura_s_New_Name {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		if(n == 1) {
			
			if(a[0] == '^') {
				
				System.out.println(1);
				return;
				
			}
			
		}
		
		int replace = (a[0] == '_' ? 1 : 0) + (a[n - 1] == '_' ? 1 : 0);
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i] == a[i - 1] && a[i] == '_') {
				
				++replace;
				
			}
			
		}
		
		System.out.println(replace);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.next().toCharArray();
			
			n = a.length;
			
			solve();
			
		}
		
	}
	
}