import java.util.Scanner;

public class A_String_Removal {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println("NO");
			return;
			
		}
		
		int []stack = new int[2];
		
		for(int i = 0; i < n; ++i) {
			
			stack[a[i] - 'a']++;
			
		}
		
		if(stack[0] == stack[1]) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
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