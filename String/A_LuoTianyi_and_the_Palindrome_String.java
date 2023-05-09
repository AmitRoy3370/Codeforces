import java.util.Scanner;

public class A_LuoTianyi_and_the_Palindrome_String {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		boolean ok = true;
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(a[i] != a[i + 1]) {
				
				ok = false;
				break;
				
			}
			
		}
		
		if(ok) {
			
			System.out.println(-1);
			return;
			
		}
		
		System.out.println(--n);
		
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