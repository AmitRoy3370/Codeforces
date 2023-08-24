import java.util.Scanner;

public class A_Deletions_of_Two_Adjacent_Letters {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char a[];

	static char x;

	private static void solve() {

		for(int i = 0; i < n; ++i) {

			if(a[i] == x) {

				if(i == 0 || i == n - 1 || (i % 2 == 0 && (n - i - 1) % 2 == 0)) {

					System.out.println("YES");
					return;

				}

			}

		}

		System.out.println("NO");

	}

	public static void main(String [] amit) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

	}

	private static void input() {

		a = in.next().toCharArray();

		x = in.next().charAt(0);

		n = a.length;
		
	}
	
}