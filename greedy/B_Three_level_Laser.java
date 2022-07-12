import java.util.Scanner;

public class B_Three_level_Laser {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long U;
	
	static long a[];
	
	static void solve() {
		
		int I = -1, J = 0, K = 0;
		
		int k = 0;
		
		double ans = -1.0;
		
		for(int i = 0; i < n; ++i) {
			
			k = Math.max(i, k);
			
			while(k + 1 < n && a[k + 1] - a[i] <= U) {
				
				++k;
				
			}
			
			if(k - i - 1 <= 0) {
				
				continue;
				
			}
			
			int j = i + 1;
			
			/*if(I == -1 || (a[k] - a[j]) * (a[K] - a[I]) > (a[k] - a[i]) * (a[K] - a[J])) {
				
				I = i;
				J = j;
				K = k;
				
			}*/
			
			ans = Math.max(ans, E(i, j, k));
			
		}
		
		if(ans < 0.0) {
			
			System.out.print(-1);
			return;
			
		}
		
		//double E = (double)((double)a[K] - (double)a[J]) / (double)((double)a[K] - (double)a[I]);
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		U = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
	}
	
	static double E(int i, int j, int k) {
		
		double E = (double)((double)a[k] - (double)a[j]) / (double)((double)a[k] - (double)a[i]);
		
		return E;
		
	}
	
}