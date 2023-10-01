import java.util.Scanner;

public class B_Jellyfish_and_Game {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, m;

	static long K;

	static long a[], b[];

	static void solve() {

		long max_a = max(a);
		long max_b = max(b);

		long min_a = min(a);
		long min_b = min(b);

		if(K % 2L == 0L) {

			if(max_b > min_a) {

				int max_index_b = search(b, max_b);
				int min_index_a = search(a, min_a);

				long temp = a[min_index_a];
				a[min_index_a] = b[max_index_b];
				b[max_index_b] = temp;

			}

			max_b = max(b);
			max_a = max(a);

			min_a = min(a);
			min_b = min(b);

			if(max_a > min_b) {

				int min_index_b = search(b, min_b);
				int max_index_a = search(a, max_a);

				long temp = b[min_index_b];
				b[min_index_b] = a[max_index_a];
				a[max_index_a] = temp;

			}

			System.out.println(sum(a));

		} else {

			if(max_b > min_a) {

				int max_index_b = search(b, max_b);
				int min_index_a = search(a, min_a);

				long temp = a[min_index_a];
				a[min_index_a] = b[max_index_b];
				b[max_index_b] = temp;

			}

			System.out.println(sum(a));

		}

	}

	public static void main(String[] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();
		m = in.nextInt();
		K = in.nextLong();

		a = new long[n];
		b = new long[m];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

		for(int i = 0; i < m; ++i) {

			b[i] = in.nextLong();

		}

	}

	static int search(long a[], long x) {

		for(int i = 0; i < a.length; ++i) {

			if(a[i] == x) {

				return i;

			} 

		}

		return -1;

	}

	static long sum(long a[]) {

		long sum = 0L;

		for(long i : a) {

			sum += i;

		}

		return sum;

	}

	static long max(long a[]) {

		long max = a[0];

		for(long i : a) {

			max = Math.max(i, max);

		}

		return max;

	}

	static long min(long a[]) {

		long min = a[0];

		for(long i : a) {

			min = Math.min(min, i);

		}

		return min;

	}

}

/*

1
5 5 6
51350557 51820889 51820889 51350557 321041583
62167154 402194975 172777188 88927749 61027547


*/