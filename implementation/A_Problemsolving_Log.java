import java.util.Scanner;

public class A_Problemsolving_Log {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static int solving_minuite[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
	
	static void solve() {
		
		int count[] = new int[26];
		
		for(char i : x) {
			
			count[i - 'A']++;
			
		}
		
		int solving_problem = 0;
		
		for(int i = 0; i != 26; ++i) {
			
			if(count[i] >= solving_minuite[i]) {
				
				++solving_problem;
				
			}
			
		}
		
		System.out.println(solving_problem);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
}