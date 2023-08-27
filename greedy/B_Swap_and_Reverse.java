import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Swap_and_Reverse {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k;

	static char a[];

	static void solve() {

		StringBuilder sb = new StringBuilder();

		if(k % 2 == 0) {

			List<Character> list = new ArrayList<>();

			for(char i : a) {

				list.add(i);

			}

			Collections.sort(list);

			for(char i : list) {

				sb.append(i);

			}

		} else {

			List<Character> even = new ArrayList<>();

			List<Character> odd = new ArrayList<>();

			for(int i = 0; i < n; ++i) {

				if((i + 1) % 2 == 0) {

					even.add(a[i]);

				} else {

					odd.add(a[i]);

				}

			}

			Collections.sort(even);
			Collections.sort(odd);

			int i = 0, j = 0;

			while(i < even.size() || j < odd.size()) {

				if(j < odd.size()) {

					sb.append(odd.get(j++));

				}

				if(i < even.size()) {

					sb.append(even.get(i++));

				}

			}

		}

		System.out.println(sb.toString().trim());

	}

	public static void main(String[] priya) {

		testCases =  in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}
		
	}

	private static void input() {

		n = in.nextInt();

		k = in.nextInt();

		a = in.next().toCharArray();
		
	}
	
}