import java.util.Scanner;

public class B_Preparing_for_the_Contest {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static void solve() {
		
		int solving_order[] = new int[n];
		
		if(k == 0) {
			
			for(int i = 0, j = n; i != n; ++i, --j) {
				
				solving_order[i] = j;
				
			}
			
			for(int i : solving_order) {
				
				System.out.print(i + " ");
			
			}
			
			System.out.println();
			return;
			
		}
		
		int start = (n - k);
		
		int index = 0;
		
		for(int i = start; i != n + 1; ++i, ++index) {
			
			solving_order[index] = i;
			
		}
		
		for(int i = start - 1; i != 0; --i) {
			
			solving_order[index++] = i;
			
		}
		
		for(int i : solving_order) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
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
		k = in.nextInt();
		
	}
	
}