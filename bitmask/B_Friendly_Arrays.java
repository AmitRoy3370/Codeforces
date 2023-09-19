import java.util.Scanner;

public class B_Friendly_Arrays {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, m;

	static long a[], b[];

	static void solve() {

		long original_xor = 0L;

		for(long i : a) {

			original_xor ^= i;

		}

		long all_xor = 0L;

		long all_xor_b = 0L;

		for(long i : b) {

			all_xor_b |= i;

		}

		for(int i = 0; i < n; ++i) {

			a[i] |= all_xor_b;

		}

		for(long i : a) {

			all_xor ^= i;

		}

		if(n % 2 == 0) {

			System.out.println(all_xor + " " + original_xor);

		} else {

			System.out.println(original_xor + " " + all_xor);

		}

	}

	public static void main(String[] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	static void input() {

		n = in.nextInt();
		m = in.nextInt();

		a = new long[n];
		b = new long[m];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

		for(int i = 0; i < m; ++i) {

			b[i] = in.nextLong();

		}

	}

}