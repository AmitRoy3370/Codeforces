import java.util.Scanner;

public class C_Given_Length_and_Sum_of_Digits {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, m, s;
	
	static void solve() {
		
		StringBuilder maxNumber = new StringBuilder();
		StringBuilder minNumber = new StringBuilder();
		
		if((m > 1 && s == 0) || (s > 9 * m)) {
			
			minNumber.append("-1");
			maxNumber.append("-1");
			
		} else {
			
			for(int i = m - 1, j, k = s; i >= 0; --i) {
				
				j = Math.max(0, k - 9 * i);
				
				if(j == 0 && i == m - 1 && k > 0) {
					
					j = 1;
					
				}
				
				minNumber.append(j);
					
				k -= j;
					
			}
			
			for(int i = m - 1, j = 0, k = s; i >= 0; --i) {
				
				j = Math.min(9, k);
				
				maxNumber.append(j);
				
				k -= j;
				
			}
			
		}
		
		System.out.println(minNumber.toString() + " " + maxNumber.toString());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = 1;
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		m = in.nextInt();
		s = in.nextInt();
		
	}
	
}