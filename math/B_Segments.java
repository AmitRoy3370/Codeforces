import java.util.Scanner;

public class B_Segments {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static void solve() {
		
		int possible_pair = (n * (n + 1)) / 2;
		
		int ans = (int)( (Math.floor((double) n / 2.0) + 1.0) * Math.ceil((double)n / 2.0));
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		solve();
		
	}
	
}