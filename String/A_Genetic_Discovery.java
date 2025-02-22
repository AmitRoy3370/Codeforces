import java.util.Scanner;

public class A_Genetic_Discovery {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static char ch[][];
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		int m = ch[0].length;
		
		for(int j = 0; j < m; ++j) {
			
			boolean find = false;
			
			for(int i = 0; i < n; ++i) {
				
				if(ch[i][j] != '.') {
					
					find = true;
					sb.append(ch[i][j]);
					break;
					
				}
				
			}
			
			if(!find) {
				
				sb.append(".");
				
			}
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static void main(String [] Priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		String s = in.next();
		
		ch = new char[n][s.length()];
		
		ch[0] = s.toCharArray();
		
		for(int i = 1; i < n; ++i) {
			
			ch[i] = in. next().toCharArray();
			
		}
		
	}
	
}