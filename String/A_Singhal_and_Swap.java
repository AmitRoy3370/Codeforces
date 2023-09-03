import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A_Singhal_and_Swap {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, m;

	static char x[], y[];

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		List<Character> list = new ArrayList<>();

		for(char i : x) {

			list.add(i);

		}

		for(char i : y) {

			list.add(i);

		}

		Collections.sort(list);

		for(int i = 0; i < n; ++i) {

			ans.append(list.get(i));

		}

		ans.append("\n");

	}

	public static void main(String[] priya) {
		
		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

		System.out.println(ans.toString());

	}
	
	private static void input() {

		x = in.next().toCharArray();

		y = in.next().toCharArray();

		n = x.length;

		m = y.length;

	}

}