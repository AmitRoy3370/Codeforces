import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class B_The_Walkway {

	static Scanner in = new Scanner(System.in);

	static int m, testCases, n;

	static long a[];

	static long N, d;

	static long can_eat(long x, long y, long d) {

		boolean e = (y - x) % d == 0L;

		long can_eat = (y - x) / d + 1 - (e ? 1L : 0L);

		return can_eat;

	}

	static void solve() {

		long start = 0L;

		if(a[0] != 1L) {

			start = 1l;

			switch_(a, 0, 1L);

			a[0] = 1L;

		}

		a[(start == 1L ? a.length - 1 : a.length - 2)] = N + 1L;

		n = (start == 1? a.length : a.length - 1);

		long cookies = 0L;

		for(int i = 1; i < n; ++i) {

			cookies += can_eat(a[i - 1], a[i], d);

		}

		long past_eaten_cookies = cookies, new_cookies = cookies;

		int shop_keeper = 0;

		for(int i = 1; i < n - 1; ++i) {

			long reduce = can_eat(a[i - 1], a[i + 1], d) - can_eat(a[i - 1], a[i], d) - can_eat(a[i], a[i + 1], d);

			new_cookies = past_eaten_cookies + reduce;

			cookies = Math.min(new_cookies, cookies);

		}

		for(int i = 1; i < n - 1; ++i) {

			long reduce = can_eat(a[i - 1], a[i + 1], d) - can_eat(a[i - 1], a[i], d) - can_eat(a[i], a[i + 1], d);

			new_cookies = past_eaten_cookies + reduce;

			if(new_cookies == cookies) {

				++shop_keeper;

			}

		}

		if(cookies == past_eaten_cookies && start == 0L) {

			++shop_keeper;

		}

		System.out.println(cookies + " " + shop_keeper);

	}

	public static void main(String []amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		N = in.nextLong();

		m = in.nextInt();

		d = in.nextLong();

		a = new long[m + 2];

		for(int i = 0; i < m; ++i) {

			a[i] = in.nextLong();

		}

	}

	static void switch_(long a[], int index, long element) {

		List<Long> list = new ArrayList<>();

		for(int i = index + 1, j = index; i < a.length; ++i) {
 
            list.add(a[j++]);
 
        }

		a[index] = element;

		for(int i = index + 1, j = 0; i < a.length; ++i, ++j) {

			a[i] = list.get(j);

		} 

	}

	static void print(long a[]) {

		for(long i : a) {

			System.out.print(i + " ");

		}

		System.out.println();

	}

}