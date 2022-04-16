import java.util.Scanner;
import java.util.Arrays;

public class C_Drazil_and_Factorial {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int n;
	
	private static char a[];
	
	private static String ch[] = {"", "", "2", "3", "223", "5", "53", "7", "7222", "7332"};
	
	private static void solve() {
		
		StringBuilder ans = new StringBuilder();
		
		for(char i : a) {
			
			ans.append(ch[i - '0']);
			
		}
		
		char b[] = ans.toString().toCharArray();
		
		int c[] = new int[b.length];
		
		for(int i = 0; i < b.length; ++i) {
			
			c[i] = b[i] - '0';
			
		}
		
		Arrays.sort(c);
		
		n = b.length;
		
		for(int i = 0; i < n / 2; ++i) {
			
			int temp = c[i];
			c[i] = c[n - i - 1];
			c[n - i - 1] = temp;
			
		}
		
		ans = new StringBuilder();
		
		for(int i : c) {
			
			ans.append(i);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = in.next().toCharArray();
		
		solve();
		
	}
	
}