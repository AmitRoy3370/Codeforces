import java.util.Scanner;

public class B_Lowest_Common_Ancestor {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static String s[];
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		int minLength = s[0].length();
		
		for(String i : s) {
			
			minLength = Math.min(minLength, i.length());
			
		}
		
		for(int j = s[0].length() - 1, k = 0; j >= 0; --j, ++k) {
			
			boolean match = true;
			
			char character = s[0].charAt(j);
			
			for(int i = 1; i < n; ++i) {
				
				if(s[i].length() - 1 - k >= 0 && s[0].charAt(j) != s[i].charAt(s[i].length() - 1 - k)) {
					
					match = false;
					break;
					
				} else if(s[i].length() - 1 - k < 0) {
					
					match = false;
					break;
					
				}
				
			} 
			
			if(match) {
				
				//System.out.println("here");
				
				sb.append(character);
				
			} else {
				
				break;
				
			}
			
		}
		
		//System.out.println("len :- " + sb.length());
		
		sb.reverse();
		
		if(sb.length() == 0 || sb.length() != minLength) {
			
			System.out.print("Not found");
			
		} else {
			
			System.out.print(sb.toString());
			
		}
		
	}
	
	public static void main(String [] Priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		s = new String[n];
		
		for(int i = 0; i < n; ++i) {
			
			s[i] = in.next();
			
		}
		
	}
	
}