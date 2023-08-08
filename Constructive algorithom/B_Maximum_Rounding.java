import java.util.Scanner;

public class B_Maximum_Rounding {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		if(n == 1 && a[0] == '1') {
			
			System.out.println(1);
			return;
			
		}
		
		StringBuilder new_number = new StringBuilder();
		
		int len = n;
		
		for(int i = len - 1; i >= 1; --i) {
			
			int present_digit = (a[i] - '0');
			
			if(present_digit >= 5) {
				
				a[i- 1]++;
				len = i;
				
			}
			
		}
		
		if((a[0] - '0') >= 5) {
			
			len = 0;
			
		}
		
		//System.out.println(len + " " + new String(a));
		
		for(int i = len; i < n; ++i) {
			
			a[i] = '0';
			
		}
		
		if(len == 0) {
			
			System.out.println(1 + "" + new String(a));
			return;
			
		}
		
		for(char i : a) {
			
			new_number.append(i);
			
		}
		
		//new_number.reverse();
		
		System.out.println(new_number);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.next().toCharArray();
		
		n = a.length;
		
	}
	
}