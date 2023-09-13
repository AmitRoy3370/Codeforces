import java.util.Scanner;

public class D1_Candy_Party_Easy_Version {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		long sum = 0L;

		for(long i : a) {

			sum += i;

		}

		if((sum % n) != 0) {

			System.out.println("NO");
			return;

		}

		long equality = sum /n;

		int bit[] = new int[32];

		for(int i = 0; i < n; ++i) {

			boolean find = false;

			for(int receving = 1; receving <= 32; ++receving) {

				for(int sending = 1; sending <= 32; ++sending) {

					if((a[i] + pow(receving) - pow(sending)) == equality) {

						find = true;

						bit[receving]++;
						bit[sending]--;

						break;

					}

				}

				if(find) {

					break;

				}

			}

			if(!find) {

				System.out.println("NO");
				return;

			}

		}

		for(int i : bit) {

			if(i > 0) {

				System.out.println("NO");
				return;

			}

		}

		System.out.println("YES");

	}

	public static void main(String[] priiya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

	static long pow(long x) {

		return 1 << (x - 1L);

	}

}