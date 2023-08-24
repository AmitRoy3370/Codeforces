import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class F_Sum_and_Product {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, q;

	static long a[];

	static long x[], y[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		Map<Long, Long> count = new HashMap<>();

		for(long i : a) {

			count.put(i, count.getOrDefault(i, 0L) + 1L);

		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < q; ++i) {

			long b = x[i];
			long c = y[i];

			long delta = b * b - 4L * c;

			if(!perfect_square(delta)) {

				sb.append("0 ");
				//System.out.println("First");
				continue;

			}

			long D = (long)Math.sqrt(delta);

			long first_root = (b + D) / 2L, second_root = (b - D) / 2L;

			if(first_root + second_root != b || first_root * second_root != c) {

				sb.append("0 ");
				//System.out.println("Second");
				continue;

			}

			if(first_root == second_root) {

				Long way = (Long)((Long)count.getOrDefault(first_root, 0L) * (Long)(count.getOrDefault(first_root, 0L) - 1L));

				way /= 2L;

				sb.append(way).append(" ");

			} else {

				Long way = (Long)((Long)count.getOrDefault(first_root, 0L) * (Long)count.getOrDefault(second_root, 0L));

				sb.append(way).append(" ");

			}

		}

		ans.append(sb.toString().trim());

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve(t + 1);

		}

		System.out.print(ans.toString());

	}

	private static void input() {

		n = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

		q = in.nextInt();

		x = new long[q];

		y = new long[q];

		for(int i = 0; i < q; ++i) {

			x[i] = in.nextLong();
			y[i] = in.nextLong();

		}

	}

	private static boolean perfect_square(long x) {

		long y = (long)Math.sqrt(x);

		return y * y == x;
		
	}
	
}