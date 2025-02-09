import java.util.Scanner;

public class B_Jzzhu_and_Sequences {
	
	static Scanner in = new Scanner(System.in);
	
	static long x, y, n;
	
	static void solve() {
		
		n %= 6;
		
		long mod = (long)(Math.pow(10, 9) + 7);
		
		long sum = 0;
		
		long a[] = new long[7];
		
		a[1] = x;
		a[2] = y;
		
		for(int i = 3; i <= 6; ++i) {
			
			a[i] = a[i - 1] - a[i - 2];
			
			a[i] = (a[i] + mod) % mod;
			
		}
		
		a[0] = a[6];
		
		sum = (a[(int)n] + mod) % mod;
		
		System.out.print(sum);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		x = in.nextLong();
		y = in.nextLong();
		n = in.nextLong();
		
	}
	
}