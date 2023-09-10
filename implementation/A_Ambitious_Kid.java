import java.util.Scanner;

public class A_Ambitious_Kid {

	static Scanner in = new Scanner(System.in);

	static int n;

	static long a[];

	static void solve() {

		long min_one = (long)Math.abs(a[0]);

		for(long i : a) {

			min_one = Math.min(min_one, (long)Math.abs(i));

		}

		System.out.println(min_one);

	}

	public static void main(String[] priya) {

		input();
		solve();
		
	}

	private static void input() {

		n = in.nextInt();
		
		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}
	
}