import java.util.Scanner;

public class A_Check_the_string {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println("NO");
			
			return;
			
		}
		
		for(int i = 0; i < n - 1; ++i) {
			
			if((a[i] - 'a') > (a[i + 1] - 'a')) {
				
				System.out.println("NO");
				return;
				
			}
			
		}
		
		int count[] = new int[3];
		
		for(char i : a) {
			
			count[i - 'a']++;
			
		}
		
		if(count[0] <= 0 || count[1] <= 0) {
			
			System.out.println("NO");
			
			return;
			
		}
		
		if((count[0] == count[2] && count[0]!= 0) || (count[1] == count[2] && count[1] != 0) || (count[2] == count[0] && count[0] != 0)) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		a = in.next().toCharArray();
		
		n = a.length;
		
		solve();
		
	}
	
}