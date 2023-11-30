import java.util.Scanner;

public class B_AB_Flipping {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		long operations = 0L;
		
		int b = 0;
		
		for(int i = n - 1; i != -1; --i) {
			
			if(x[i] == 'B') {
				
				++b;
				continue;
				
			}
			
			operations += b;
			
			if(b > 0) {
				
				b = 0;
				x[i] = 'B';
				++i;
				
			}
			
		}
		
		System.out.println(operations);
		
	}
	
	public static void main(String [] priya) {
		
		testCases =  in.nextInt();
		
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