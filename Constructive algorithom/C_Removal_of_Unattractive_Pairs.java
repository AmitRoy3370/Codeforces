import java.util.Scanner;

public class C_Removal_of_Unattractive_Pairs {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		int count[] = new int[26];
		
		for(char i : x) {
			
			count[i - 'a']++;
			
		}
		
		int max_count = 0;
		
		for(int i : count) {
			
			max_count = Math.max(max_count, i);
			
		}
		
		int remaining_element = n - max_count;
		
		int min_len = Math.max(max_count - remaining_element, 0);
		
		if(n % 2 == 1 && min_len == 0) {
			
			min_len = 1;
			
		}
		
		System.out.println(min_len);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
	
	}
	
}