import java.util.Scanner;

public class C_Riverside_Curio {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[];
	
	static void solve() {
		
		long current_mark = 0;
		
		long height[] = new long[n];
		
		for(int i = n - 1; i >= 0; --i) {
			
			current_mark = Math.max(0, current_mark - 1);
			current_mark = Math.max(current_mark, a[i] + 1);
			
			height[i] = current_mark;
			
		}
		
		//print(height);
		
		long ans = 0;
		
		current_mark = 0;
		
		for(int i = 0; i < n; ++i) {
			
			current_mark = Math.max(current_mark, height[i]);
			
			ans += current_mark;
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			ans -= (a[i] + 1);
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
	static void print(int a[]) {
		
		for(int i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}