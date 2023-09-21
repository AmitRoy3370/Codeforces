import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Colorful_Table {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		Map<Long, element> map = new HashMap<>();

		for(int i = 0; i < n; ++i) {

			if(map.containsKey(a[i])) {

				map.get(a[i]).ending_position = i;

			} else {

				map.put(a[i], new element(a[i], i, i));

			}

		}

		int L = Integer.MAX_VALUE, R = -1;

		for(long i = k; i >= 1; --i) {

			if(!map.containsKey(i)) {
				
				continue;

			}

			L = Math.min(L, map.get(i).starting_position);
			R = Math.max(R, map.get(i).ending_position);

			map.get(i).starting_position = L;
			map.get(i).ending_position = R;

		}

		StringBuilder sb = new StringBuilder();

		for(long i = 1; i <= k; ++i) {

			if(!map.containsKey(i)) {

				sb.append(0).append(" ");

			} else {

				sb.append(((map.get(i).ending_position - map.get(i).starting_position + 1) * 2) ).append(" ");

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

		k = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

	static class element {

		long element;
		int starting_position, ending_position;

		public element(long element, int starting_position, int ending_position) {

			this.element = element;
			this.starting_position = starting_position;
			this.ending_position = ending_position;

		}
	}

}