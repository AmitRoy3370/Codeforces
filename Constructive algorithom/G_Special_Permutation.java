import java.util.Scanner;

public class G_Special_Permutation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static void solve() {
		
		if(n < 4) {
			
			System.out.println(-1);
			return;
			
		}
		
		int start = n % 2 == 1 ? n : n - 1;
		
		for(int i = start; i >= 1; i -= 2) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.print(4 + " " + 2 + " ");
		
		for(int i = 6; i <= n; i += 2) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			solve();
			
		}
		
	}
	
}