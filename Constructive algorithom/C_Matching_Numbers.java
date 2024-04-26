import java.util.Scanner;

public class C_Matching_Numbers {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static String a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		boolean yes = true;
		
		if(n % 2 == 0) {
			
			yes = false;
			
		} else {
			
			int first = 1, second = 2 * n;
			
			int till = (n + 1) / 2;
			
			int i = 0;
			
			while(till > 0) {
				
				a[i++] = (first) + (" ") + (second);
				
				++first;
				--second;
				--second;
				
				--till;
				
			}
			
			till = (n / 2);
			
			second = (2 * n - 1);
			
			while(till > 0) {
				
				a[i++] = (first) + (" ") + (second);
				
				++first;
				--second;
				--second;
				
				--till;
				
			}
			
		}
		
		if(yes) {
			
			ans.append("YES").append("\n");
			
			StringBuilder sb = new StringBuilder();
			
			for(String i : a) {
				
				sb.append(i).append("\n");
				
			}
			
			ans.append(sb.toString().trim()).append("\n");
			
		} else {
			
			ans.append("NO").append("\n");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new String[n];
		
	}
	
}