import java.util.Scanner;

public class A_Binary_Imbalance {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases;
	
	static char x[];
	
	static void solve() {
		
		int count[] = new int[2];
		
		for(char i : x) {
			
			count[i - '0']++;
			
		}
		
		if(count[0] > count[1]) {
			
			System.out.println("YES");
			
		} else {
			
			boolean yes = false;
			
			for(int i = 0; i < n - 1; ++i) {
				
				if(x[i] != x[i + 1] && x[i] == '1' && x[i + 1] == '0') {
					
					yes = true;
					break;
					
				} else if(x[i] != x[i + 1] && x[i] == '0' && x[i + 1] == '1') {
					
					yes = true;
					break;
					
				}
				
			}
			
			if(yes) {
				
				System.out.println("YES");
				
			} else {
				
				System.out.println("NO");
				
			}
			
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
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
}