import java.util.Scanner;

public class C_Anonymous_Informant {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long k;
	
	static long a[];
	
	static void solve() {
		
		k = Math.min(k, n);
		
		boolean visited[] = new boolean[n + 1];
		
		int index = n;
		
		while(k-- > 0) {
			
			if(a[index] > n) {
				
				System.out.println("NO");
				return;
				
			}
			
			visited[index] = true;
			
			index -= (int)a[index];
			
			if(index < 1) {
				
				index += n;
				
			}
			
			if(visited[index]) {
				
				break;
				
			}
			
		}
		
		System.out.println("YES");
		
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
		k = in.nextLong();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}