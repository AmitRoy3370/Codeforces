import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class G_White_Black_Balanced_Subtrees {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static int a[];

	static char x[];

	static long ans = 0L;

	static long dp(int source, List<Integer> list[]) {

		long val = (x[source - 1] == 'B' ? -1 : 1);

		if(list[source].isEmpty()) {

			return val;

		}

		for(int i : list[source]) {

			val += dp(i, list);

		}

		if(val == 0L) {

			++ans;

		}

		return val;

	}

	static void solve() {

		List<Integer> list[] = new ArrayList[n + 1];

		for(int i = 0; i <= n; ++i) {

			list[i] = new ArrayList<>();

		}

		for(int i = 2; i <= n; ++i) {

			list[a[i]].add(i);

		}

		ans = 0L;

		dp(1, list);

		System.out.println(ans);

	}

	public static void main(String[] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();

		a = new int[n + 3];

		for(int i = 2; i <= n; ++i) {

			a[i] = in.nextInt();

		}

		x = in.next().toCharArray();

	}

}