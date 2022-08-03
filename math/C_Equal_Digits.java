import java.util.Scanner;

public class C_Equal_Digits {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static char a[], original[];
	
	static void solve() {
		
		original = new char[n];
		
		for(int i = 0; i < n; ++i) original[i] = a[i];
		
		char ch = a[0];
		
		for(int i = 0; i < n; ++i) a[i] = (ch);
		
		if(ch == '9') {
			
			System.out.print(new String(a));
			return;
			
		}
		
		/*for(int i = 1; i < n; ++i) {
			
			//System.out.println(ch + " " + original[i]);
			
			if(original[i] - '0' > ch - '0') {
				
				ch = original[i];
				
				break;
				
			}
			
		}*/
		
		++ch;
		
		char next = ch;
		
		char b[] = new char[n];
		
		for(int i = 0; i < n; ++i) b[i] = (next);
		
		if(Long.parseLong(new String(a)) < Long.parseLong(new String(original))) {
			
			System.out.print(new String(b));
			
		} else {
			
			System.out.print(new String(a));
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		a = in.next().toCharArray();
		
		n = a.length;
		
		solve();
		
	}
	
}