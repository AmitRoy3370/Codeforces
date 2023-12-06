import java.util.Scanner;

public class A_Rook {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static char x[];
	
	static void solve() {
		
		StringBuilder sb = new StringBuilder();
		
		int col = x[0] - 'a';
		int raw = x[1] - '0';
		
		char ch[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		// upper portion
		
		for(int i = raw + 1; i <= 8; ++i) {
			
			sb.append(ch[col]).append(i).append("\n");
			
		}
		
		// lower case
		
		for(int i = raw - 1; i >= 1; --i) {
			
			sb.append(ch[col]).append(i).append("\n");
			
		}
		
		// left
		
		for(int i = col + 1; i != 8; ++i) {
			
			sb.append(ch[i]).append(raw).append("\n");
			
		}
		
		// right
		
		for(int i = col - 1; i >= 0; --i) {
			
			sb.append(ch[i]).append(raw).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		
	}
	
}