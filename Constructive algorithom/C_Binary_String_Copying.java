import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Binary_String_Copying {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static int L[], R[];
	
	static char x[];
	
	static void solve() {
		
		int one[] = new int[n + 1];
		
		one[n] = n;
		
		int zero[] = new int[n];
		
		zero[0] = (x[0] == '0' ? 0 : - 1);
		
		for(int i = 1; i < n; ++i) {
			
			zero[i] = zero[i - 1];
			
			if(x[i] == '0') {
				
				zero[i] = i;
				
			}
			
		}
		
		for(int i = n - 1; i >= 0; --i) {
			
			one[i] = one[i + 1];
			
			if(x[i] == '1') {
				
				one[i] = i;
				
			}
			
		}
		
		//print(one);
		//print(zero);
		
		Map<String, Boolean> map = new HashMap<>();
		
		for(int i = 0; i < m; ++i) {
			
			int l = L[i] - 1;
			int r = R[i] - 1;
			
			l = one[l];
			r = zero[r];
			
			if(r >= l) {
				
				String s = l + "_" + r;
				
				map.put(s, true);
				
			} else {
				
				map.put(-1 + "_" + -1, true);
				
			}
			
		}
		
		System.out.println(map.size());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		m = in.nextInt();
		
		x = in.next().toCharArray();
		
		L = new int[m];
		
		R = new int[m];
		
		for(int i = 0; i < m; ++i) {
			
			L[i] = in.nextInt();
			
			R[i] = in.nextInt();
			
		}
		
	}
	
	static void print(int a[]) {
		
		for(int i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}