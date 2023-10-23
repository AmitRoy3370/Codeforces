import java.util.Scanner;

public class B_Chemistry {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static char a[];
	
	static void solve() {
		
		int counter[] = new int[26];
		
		for(char i : a) {
			
			counter[i - 'a']++;
			
		}
		
		int remove = 0;
		
		for(int i : counter) {
			
			if(i == 0) {
				
				continue;
				
			}
			
			if(i % 2 == 1) {
				
				++remove;
				
			}
			
		}
		
		if(remove > k + 1) {
			
			System.out.println("NO");
			
		} else {
			
			System.out.println("YES");
		
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = in.next().toCharArray();
		
	}
	
	private static boolean palindrome(char x[]) {
		
		for(int i = 0; i < n / 2; ++i) {
			
			if(x[i] != x[n - i - 1]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
}
