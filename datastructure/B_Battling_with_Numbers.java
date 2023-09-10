import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Battling_with_Numbers {

	static Scanner in = new Scanner(System.in);

	static int n, m;

	static long a[], b[], c[], d[];

	static void solve() {

		Map<Long, long[]> B = new HashMap<>();

		Map<Long, long[]> D = new HashMap<>();

		for(long i : a) {

			B.put(i, new long[]{0});

		}

		for(long i : c) {

			D.put(i, new long[]{0});

		}

		for(int i = 0; i < n; ++i) {

			B.get(a[i])[0] = b[i];

		}

		for(int i = 0; i < m; ++i) {

			D.get(c[i])[0] = d[i];

		}

		for(long i : D.keySet()) {

			if(!B.containsKey(i)) {

				System.out.println(0);
				return;

			} else {

				B.get(i)[0] -= D.get(i)[0];

			}

			if(B.get(i)[0] < 0) {

				System.out.println(0);
				return;

			}

		}

		long ans = 1;

		for(long i : B.keySet()) {

			if(B.get(i)[0] > 0) {

				ans = (ans * 2) % 998_244_353;

			}

		}

		System.out.println(ans);

	}

	public static void main(String[] priya) {

		input();
		solve();
		
	}

	private static void input() {

		n = in.nextInt();

		a = new long[n];
		b = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

		for(int i = 0; i < n; ++i) {

			b[i] = in.nextLong();

		}

		m = in.nextInt();

		c = new long[m];
		d = new long[m];

		for(int i = 0; i < m; ++i) {

			c[i] = in.nextLong();

		}

		for(int i = 0; i < m; ++i) {

			d[i] = in.nextLong();

		}

	}

}