import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class B_Singhal_and_Equality {

	static Scanner in = new Scanner(System.in);

	static int testCases, n;

	static char a[];

	static void solve() {

		Integer frequency[] = new Integer[26];

		Arrays.fill(frequency, 0);

		for(char i : a) {

			frequency[(i - 'a') ]++;

		}

		Arrays.sort(frequency, Collections.reverseOrder());

		/*for(int i = 0; i < 26; ++i) {

			System.out.print(frequency[i] + " ");

		}*/

		int ans = n;

		for(int i = 1; i <= 26; ++i) {

			if(n % i == 0) {

				int x = n / i, y = 0;

				for(int j = 0; j < i; ++j) {

					y += Math.min(frequency[j], x);

				}

				ans = Math.min(ans, n - y);

			}

		}

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

		a = in.next().toCharArray();

		n = a.length;

	}
	
}