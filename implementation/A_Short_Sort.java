import java.util.Scanner;

public class A_Short_Sort {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char x[];

	static void solve() {

		if(x[0] == 'a' || x[1] == 'b' || x[2] == 'c') {

			System.out.println("YES");

		} else {

			System.out.println("NO");
			
		}

	}

	public static void main(String[] amit) {

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