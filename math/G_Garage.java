import java.util.Scanner;

public class G_Garage {
	
	static Scanner in = new Scanner(System.in);
	
	static long n;
	
	static void solve() {
		
		if(n == 1L) {
			
			System.out.println(3);
			return;
			
		}
		
		long ans = n + 3L + n / 3L;
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextLong();
		
		solve();
		
	}
	
}