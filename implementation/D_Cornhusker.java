import java.util.Scanner;

public class D_Cornhusker {
	
	static Scanner in = new Scanner(System.in);
	
	static long a[], l[];
	
	static long N, kwf;
	
	static void solve() {
		
		long kernels = 0L;
		
		for(int i = 0; i != 5; ++i) {
			
			kernels += (l[i] * a[i]);
			
		}
		
		kernels /= 5L;
		
		long per_kernels = (N * kernels) / kwf;
		
		System.out.println(per_kernels);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		a = new long[5];
		l = new long[5];
		
		for(int i = 0; i != 5; ++i) {
			
			a[i] = in.nextInt();
			l[i] = in.nextLong();
			
		}
		
		N = in.nextLong();
		
		kwf = in.nextLong();
		
	}
	
}