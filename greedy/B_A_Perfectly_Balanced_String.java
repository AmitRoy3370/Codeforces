import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class B_A_Perfectly_Balanced_String {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		Set<Character> set = new HashSet<>();
		
		int i = 0;
		
		for(i = 0; i < n; ++i) {
			
			int prev = set.size();
			
			set.add(a[i]);
			
			int present = set.size();
			
			if(present == prev) {
				
				break;
				
			}
			
		}
		
		for(int j = i; j < n; ++j) {
			
			if(a[j] != a[j - i]) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		System.out.println("YES");
		
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