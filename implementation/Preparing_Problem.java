import java.util.Scanner;

public class Preparing_Problem {

	static Scanner in = new Scanner(System.in);

	static int n, t1, t2;

	static void solve() {

		if(t1 > t2) {

			int temp = t1;
			t1 = t2;
			t2 = temp;

		}

		int L = 1, R = n;

		int count_t1 = 0;

		while(R >= L) {

			int mid = (L + R) / 2;

			int current_count = ((mid * t1) / t2) + mid;

			if(current_count < n) {

				L = mid + 1;

			} else {

				R = mid - 1;
				count_t1 = mid;

			}

		}

		int count_t2 = (count_t1 * t1) / t2;

		count_t2 += ((count_t1 + count_t2 <= n && count_t2 * t2 < count_t1 * t1) ? 1 : 0);

		long count = count_t2 + count_t1;

		long time = Math.max(count_t1 * t1, count_t2 * t2);

		System.out.println(count + " " + time);

	}

	public static void main(String[] priya) {

		input();
		solve();
		
	}

	private static void input() {

		n = in.nextInt();
		t1 = in.nextInt();
		t2 = in.nextInt();

	}

}