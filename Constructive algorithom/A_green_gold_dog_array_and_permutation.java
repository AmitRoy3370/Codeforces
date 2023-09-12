import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A_green_gold_dog_array_and_permutation {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static long a[];

	static void solve() {

		List<room> list = new ArrayList<>();

		int b[] = new int[n];

		int minimum_value = 1;

		for(int i = 0; i < n; ++i) {

			list.add(new room(a[i], i));

		}

		Collections.sort(list, Collections.reverseOrder());

		for(room i : list) {

			b[i.index] = minimum_value++;

		}

		StringBuilder sb = new StringBuilder();

		for(int i : b) {

			sb.append(i).append(" ");

		}

		System.out.println(sb.toString());

	}

	public static void main(String[] args) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();

		a = new long[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextLong();

		}

	}

	static class room implements Comparable<room> {

		long element;
		int index;

		public room(long element, int index) {

			this.element = element;
			this.index = index;

		}

		public int compareTo(room r) {

			if(this.element > r.element) {

				return 1;

			} else if(this.element < r.element) {

				return -1;

			}

			return 0;

		}

	}

}