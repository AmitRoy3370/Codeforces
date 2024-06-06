import java.util.Scanner;

public class C_Divan_and_bitwise_operations {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static int L[], R[];
	
	static long X[], a[];
	
	static long mod = (long)(1e9 + 7);
	
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		long coziness = 0L;
		
		int x = 0;
		
		for(long i : X) {
			
			x |= i;
			
		}
		
		coziness = (pow(2L, (long)(n - 1)) * x) % mod;
		
		sb.append(coziness).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		//build();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		L = new int[m];
		R = new int[m];
		X  = new long[m];
		
		for(int i = 0; i != m; ++i) {
			
			L[i] = in.nextInt();
			R[i] = in.nextInt();
			X[i] = in.nextLong();
			
		}
		
	}
	private static long pow(long base, long pow) {
      if(pow == 0) {
        return 1L;
      }
      if(base == 0) {
        return 0L;
      }
      long ans = 1L;
      while(pow > 0L) {
        if(pow % 2L == 1) {
            ans *= base;
            ans %= (long)(1e9 + 7);
        }
        base *= base;
        base %= (long)(1e9 + 7);
        pow /= 2L;
      }
      return ans;
    }
	static void build() {
		
		a = new long[300001];
		
		a[0] = 1L;
		
		for(int i = 1; i != a.length; ++i) {
			
			a[i] = a[i - 1] * 2L;
			a[i] %= mod;
			
		}
		
	} 
 
}