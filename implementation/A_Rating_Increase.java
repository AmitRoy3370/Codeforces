import java.util.Scanner;

public class A_Rating_Increase {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		StringBuilder A = new StringBuilder();
		StringBuilder B = new StringBuilder();
		
		int i = 1;
		
		A.append(x[0]);
		
		while(i != n && x[i] == '0') {
			
			A.append(x[i++]);
			
		}
		
		while(i < n) {
			
			B.append(x[i++]);
			
		}
		
		if(B.length() == 0) {
			
			System.out.println(-1);
			
		} else {
			
			long a = Long.parseLong(A.toString());
			long b = Long.parseLong(B.toString());
			
			if(b > a) {
				
				System.out.println(a + " " + b);
				
			} else {
				
				System.out.println(-1);
				
			}
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		
		n = x.length;
		
	}
	
}