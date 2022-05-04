import java.util.Scanner;

public class C_Rotation_Matching {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[], b[];
	
	static void solve() {
		
		int max = a[0];
		
		for(int i : a) {
			
			max = Math.max(max, i);
			
		}
		
		for(int i : b) {
			
			max = Math.max(i, max);
			
		}
		
		int position [] = new int[max + 1];
		
		int count[] = new int[max + 1];
		
		int index = 0;
		
		for(int i : a) {
			
			position[i] = index++;
			
		}
		
		int ans = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			int current = position[b[i]] - i;
			
			if(current < 0) {
				
				current += n;
				
			}
			
			count[current]++;
			
			ans = Math.max(ans, count[current]);
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new int[n];
		b = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}