import java.util.Scanner;

public class C_The_Third_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static long mod = (long)((long)Math.pow(10, 9) + 7L);
	
	static void solve() {
		
		long ans = 1;
		
		int position[] = new int[n];
		
		int index = 0;
		
		for(int i : a) {
			
			position[i] = index;
			
			++index;
			
		}
		
		int left_corner = position[0], right_corner = position[0];
		
		for(int i = 1; i < n; ++i) {
			
			if(left_corner > position[i]) {
				
				left_corner = position[i];
				
			} else if(position[i] > right_corner) {
				
				right_corner = position[i];
				
			} else {
				
				ans *= (right_corner - left_corner + 1 - i);
				
				ans %= mod;
				
			}
			
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new int[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextInt();
				
			}
			
			solve();
			
		}
		
	}
	
}