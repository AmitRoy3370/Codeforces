import java.util.Scanner;

public class A_Odd_One_Out {
	
	static Scanner in = new Scanner(System.in);
	
	static int a, b, c, testCases;
	
	static void solve() {
		
		int digit[] = new int[10];
		
		digit[a]++;
		digit[b]++;
		digit[c]++;
		
		if(digit[a] == 1) {
			
			System.out.println(a);
			
		} else if(digit[b] == 1) {
			
			System.out.println(b);
			
		} else {
			
			System.out.println(c);
			
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
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		
	}
	
}