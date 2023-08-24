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

		StringBuilder sb = new StringBuilder();

		Map<Long, Long> map = new HashMap<>();

		for(long i : a) {

			map.put(i, map.getOrDefault(i, 0L) + 1L);

		}

		for(int i = 0; i < q; ++i) {

			long b = x[i], c = y[i];

			long determinator = b * b - 4L * c;

			//System.out.println(determinator);

			if(!perfect_square(determinator)) {

				sb.append(0).append(" ");
				continue;

			}

			determinator = (long)Math.sqrt(determinator);

			long first_root = (b + determinator) / 2L;

			long second_root = (b - determinator) / 2L;

			if(first_root + second_root != b || first_root * second_root != c) {

				//System.out.println("at here " + first_root + " " + second_root);

				sb.append(0).append(" ");
				continue;

			}

			if(first_root == second_root) {

				long way = map.getOrDefault(first_root, 0L) * (map.getOrDefault(first_root, 0L) - 1L);

				way /= 2L;

				//System.out.println("I came from here");

				sb.append(way).append(" ");

			} else {

				long way = map.getOrDefault(first_root, 0L) * map.getOrDefault(second_root, 0L);

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

		//System.out.println(y * y + " " + x);

		return (x == y * y);
		
	}

}