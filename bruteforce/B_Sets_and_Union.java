import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class B_Sets_and_Union {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static List<Long> list[];

	static void solve() {

		Set<Long> X = new HashSet<>();

		for(int i = 0; i < n; ++i) {

			for(long j : list[i]) {

				X.add(j);

			}

		}

		long answer = 0L;

		for(long element : X) {

			int count[] = new int[53];

			long length_has = 0;

			for(int i = 0; i < n; ++i) {

				boolean find_it = false;

				for(long j :  list[i]) {

					count[(int)j]++;

					if(j == element) {

						find_it = true;

					}

				}

				if(find_it) {

					for(long j : list[i]) {

						count[(int)(j)]--;

					}

				}

			}

			for(int j : count) {

				if(j <= 0) {

					continue;

				}

				++length_has;

			}

			answer = Math.max(answer, length_has);

		}

		System.out.println(answer);

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

		list = new ArrayList[n];

		for(int i = 0; i < n; ++i) {

			list[i] = new ArrayList<>();

		}

		for(int i = 0; i < n; ++i) {

			int m = in.nextInt();

			for(int j = 0; j < m; ++j) {

				list[i].add(in.nextLong());
				
			}

		}

	}

}