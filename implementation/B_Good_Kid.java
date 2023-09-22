import java.util.Scanner;

public class B_Good_Kid {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static int a[];

	static void solve() {

		long max_value = Long.MIN_VALUE;

		for(int i = 0; i < n; ++i) {

			int previous = a[i];

			a[i]++;

			long present_product = 1L;

			for(int j = 0; j < n; ++j) {

				present_product *= a[j];

			}

			a[i] = previous;

			max_value = Math.max(max_value, present_product);

		}

		System.out.println(max_value);

	}

	public static void main(String[] args) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		} 
		
	}

	private static void input() {

		n = in.nextInt();

		a = new int[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextInt();

		}

	}

}