import java.util.Scanner;

public class B_The_String_Has_a_Target {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		int min_index = 0;
		
		char min_character = 'z';
		
		for(int i = 0; i < n; ++i) {
			
			if((min_character - 'a') >= a[i] - 'a') {
				
				min_character = a[i];
				min_index = i;
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(a[min_index]);
		
		for(int i = 0; i < n; ++i) {
			
			if(i == min_index) {
				
				continue;
				
			}
			
			sb.append(a[i]);
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}