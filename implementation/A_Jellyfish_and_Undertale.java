import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class A_Jellyfish_and_Undertale {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;
	static long A, B;

	static long a[];

	static void solve() {

		List<Long> list = new ArrayList<>();

		for(long i : a) {

			list.add(i);

		}

		Collections.sort(list);

		long count_down = B, time_taken = 0L;

		for(long i : list) {

			time_taken  += count_down - 1L;

			count_down = 1L;

			count_down += i;

			if(count_down > A) {

				count_down = A;

			}

		}

		time_taken += Math.min(A, count_down);

		System.out.println(time_taken);

	}

	public static void main(String[] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		A = in.nextLong();
		B = in.nextLong();

		n = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

}