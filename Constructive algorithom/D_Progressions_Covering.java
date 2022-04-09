import java.util.Scanner;

public class D_Progressions_Covering {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static long a[], f[], g[];
	
	static long ans = 0;
	
	static long get(long ad, long need)
    {
        if(need % ad == 0)return need/ad;
        return need/ad+1;
    }
	
	static void solve(int len, int r, long sum) {
		
		if(sum < 0)return;
        long num = get(r - len +1, sum);
        ans += num;
        g[r-1] += num;
        if(len >= 2)g[len - 2] -= num;
        f[r] += num*(r - len + 1);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new long[n + 1];
		
		f = new long[n + 2];
		
		g = new long[n + 2];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = n; i > 0; --i) {
			
			g[i] += g[i + 1];
			f[i] += (f[i + 1] - g[i]);
			
			solve(Math.max(1, i - k + 1), i, a[i] - f[i]);
			
		}
		
		System.out.print(ans);
		
	}
	
}