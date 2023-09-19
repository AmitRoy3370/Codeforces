import java.util.Scanner;

public class A_MEXanized_Array {

	static Scanner in = new Scanner(System.in);

	static int testCases, n, k, x;

	static StringBuilder ans = new StringBuilder();

	static void solve() {

		if(k > n) {

			ans.append("-1").append("\n");
			return;

		}

		int a[] = new int[n];

		for(int i = 0; i < n; ++i) {

			a[i] = i;

		}

		int i = 0;

		while(i < n && i != k) {

			++i;

		}

		for(int j = i; j < n; ++j) {

			a[j] = (x == k ? x - 1 : x);

		}

		for(int i1 : a) {

			if(i1 > x) {

				ans.append("-1").append("\n");
				return;

			}

		}

		long sum = 0L;

		for(int i1 : a) {

			sum += i1;

		}

		ans.append(sum).append("\n");

	}

	public static void main(String[] priya) {

		testCases = in.nextInt();

		for(int t = 0; t < testCases; ++t) {

			input();
			solve();

		}

		System.out.println(ans.toString());
		
	}

	static void input() {

		n = in.nextInt();
		k = in.nextInt();
		x = in.nextInt();

	}

}