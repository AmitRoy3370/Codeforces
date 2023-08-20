import java.util.Scanner;

public class B_Fancy_Coins {

	static Scanner in = new Scanner(System.in);

	static int testCases;

	static long m, k, a1, ak;

	static void solve() {

		if(m <= a1 || (m / k >= m && m % k >= m)) {

			System.out.println(0);

		} else {

			long need_k = Math.min(ak, m / k);
			long need_1 = Math.min(a1, m - need_k * k);

			long remaining_need = m - need_1 - need_k * k;

			if(remaining_need % k == 0) {

				System.out.println((remaining_need / k));

			} else if(k - remaining_need % k <= a1){

				System.out.println((remaining_need / k + 1));

			} else {

				System.out.println((remaining_need / k + remaining_need % k));

			}

		}

	}

	public static void main(String [] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		m = in.nextLong();
		k = in.nextLong();
		a1 = in.nextLong();
		ak = in.nextLong();

	}

}