import java.util.Scanner;

public class A_Don_t_Try_to_Count {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static char x[], y[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		int operations = 0;
		
		String s = new String(x);
		
		String target = new String(y);
		
		while(!s.contains(target)) {
			
			s += s;
	
			++operations;
			
			if(s.contains(target)) {
				
				break;
				
			}
			
			if(s.length() > n * m) {
				
				operations = -1;
				break;
				
			}
			
		}
		
		ans.append(operations).append("\n");
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		} 
		
		System.out.println(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		x = in.next().toCharArray();
		y = in.next().toCharArray();
		
	}
	
}