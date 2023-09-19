import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class C_Colorful_Table {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		Map<Long, element_position> map = new HashMap<>();

		for(int i = 0; i < n; ++i) {

			if(map.containsKey(a[i])) {

				map.get(a[i]).second_position = i; 
			
			} else {

				map.put(a[i], new element_position(a[i], i, i));

			}

		}

		int l = Integer.MAX_VALUE, r = -1;

		for(long i = k; i >= 1; --i) {

			if(!map.containsKey(i)) {

				continue;

			}

			l = Math.min(l, map.get(i).first_position);
			r = Math.max(r, map.get(i).second_position);

			map.get(i).first_position = l;
			map.get(i).second_position = r;

		}

		StringBuilder sb = new StringBuilder();

		for(int i = 1; i <= k; ++i) {

			if(map.containsKey((long)i)) {

				sb.append(((map.get((long)i)).second_position - map.get((long)i).first_position + 1) * 2).append(" ");
			
			} else {

				sb.append(0).append(" ");

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

	static class element_position {

		long element;

		int first_position, second_position;

		public element_position(long element, int first_position, int second_position) {

			this.element = element;
			this.first_position = first_position;
			this.second_position = second_position;

		}

	}

}