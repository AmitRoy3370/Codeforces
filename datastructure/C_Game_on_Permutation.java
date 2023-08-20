import java.util.Scanner;
import java.util.TreeSet;

public class C_Game_on_Permutation {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static int p[];

	static void solve() {

		TreeSet<Integer> all = new TreeSet<>();

		TreeSet<Integer> alice = new TreeSet<>();

		all.add(p[0]);

		for(int i = 1; i < n; ++i) {

			Integer smallest_element_from_left = all.floor(p[i]);
			Integer smallest_element_from_left_of_alice = alice.floor(p[i]);

			if(smallest_element_from_left != null && all.contains(smallest_element_from_left)) {

				if(smallest_element_from_left_of_alice == null || !alice.contains(smallest_element_from_left_of_alice)) {

					alice.add(p[i]);

				}

			}

			all.add(p[i]);

		}

		System.out.println(alice.size());

	}

	public static void main(String [] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		n = in.nextInt();

		p = new int[n];

		for(int i = 0; i < n; ++i) {

			p[i] = in.nextInt();

		}

	}

}