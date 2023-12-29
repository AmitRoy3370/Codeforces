import java.util.Scanner;

public class D_Unnatural_Language_Processing {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		boolean vowel[] = new boolean[26];
		
		vowel['a' - 'a'] = true;
		vowel['e' - 'a'] = true;
		vowel['i' - 'a'] = true;
		vowel['o' - 'a'] = true;
		vowel['u' - 'a'] = true;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			
			char ch = x[i];
			
			if(!vowel[ch - 'a']) {
				
				// ensure c
				
				sb.append(ch);
				
			} else {
				
				sb.append(ch);
				
				// ensure v
				
				if(i + 1 >= n - 1) {
					
					
				} else {
					
					// try to find cvc
					
					//  c  a  c.  c
					
					//   c  a  c
					
					if(i + 2 < n) {
						
						if(!vowel[x[i + 1] - 'a'] && !vowel[x[i + 2] - 'a']) {
							
							sb.append(x[i + 1]);
							sb.append(".");
							++i;
							
						} else {
							
							sb.append(".");
							
						}
						
					} else {
						
						sb.append(".");
						
					}
					
				}
				
			}
			
		}
		
		System.out.println(sb.toString());
		
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
		
		x = in.next().toCharArray();
		
	}
	
}