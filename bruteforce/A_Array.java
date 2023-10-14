import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class A_Array {

	static Scanner in = new Scanner(System.in);

	static int n;

	static int a[];

	static void solve() {

		Arrays.sort(a);

		int index = 0;

		List<Integer> _ve = new ArrayList<>();
		List<Integer> ve_ = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();

		long negative = a[0];

		_ve.add(a[0]);

		++index;

		while(index < n && negative * a[index] < 0L && a[index] < 0L) {

			negative *= a[index];

			_ve.add(a[index]);

			++index;

		}

		if(index < n && a[index] < 0L) {

			int j = index, neg = 0;

			while(j < n && a[j] < 0L) {

				++neg;

				++j;

			}

			if(neg % 2 == 1) {

				zero.add(a[index++]);

			}

			if(a[index] == 0L) {

				while(index < n && a[index] == 0L) {

					zero.add(a[index++]);

				}
				
			}

			long positive = a[index];

			ve_.add(a[index]);

			++index;

			while(index < n && positive * a[index] > 0L) {

				ve_.add(a[index]);
				++index;

			}

		}

		while(index < n && a[index] == 0) {

			zero.add(a[index]);
			++index;

		}

		while(index < n) {

			if(a[index] < 0L) {

				zero.add(a[index++]);
				continue;

			}

			ve_.add(a[index]);

			++index;

		}

		System.out.print(_ve.size() + " ");

		for(int i : _ve) {

			System.out.print(i + " ");

		}

		System.out.print("\n" + ve_.size() + " ");

		for(int i : ve_) {

			System.out.print(i + " ");

		}

		System.out.print("\n" + zero.size() + " ");

		for(int i : zero) {

			System.out.print(i + " ");

		}


	}

	public static void main(String[] args) {
		
		input();
		solve();

	}

	private static void input() {

		n = in.nextInt();

		a = new int[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextInt();

		}

	}
	
}

/*

5
-1 -2 1 2 0

*/