import java.util.Scanner;

public class A_Not_a_Substring {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char x[];

	static void solve() {

		if(n == 2 && new String(x).equals("()")) {

			System.out.println("NO");
			return;
			
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; ++i) {

			sb.append("(");

		}

		for(int i = 0; i < n; ++i) {

			sb.append(")");

		}

		if(sb.toString().contains(new String(x))) {

			sb = new StringBuilder();

			for(int i = 0; i < n; ++i) {

				sb.append("()");

			}

			System.out.println("YES");

			System.out.println(sb.toString());

		} else {

			System.out.println("YES");

			System.out.println(sb.toString());

		}

	}

	public static void main(String [] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		x = in.next().toCharArray();

		n = x.length;

	}

}