import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class D_Two_Pirates_2 {

	static Scanner in = new Scanner(System.in);

	static int n;

	static double a[];

	static StringBuilder ans = new StringBuilder();

	private static void solve() {

		double dp[][] = new double[n + 1][n + 1];

		boolean odd = (n % 2 == 1) ? true : false;

		sort(a, 0, n - 1);

		for(double i = 1; i <= n; ++i) {

			for(double j = 1; j <= n; ++j) {

				if(!odd) {

					double left_point = (double)((double)((j - 1.0) * 1.0) / (double)(i * 1.0));

					double right_point = (double)((double)((i - j) * 1.0) / (double)(i * 1.0));

					dp[(int)i][(int)j] = dp[(int)(i - 1)][(int)(j - 1)] * left_point + dp[(int)(i - 1)][(int)j] * right_point;

					continue;

				}

				if(i == j) {

					dp[(int)i][(int)j] = 1.0;

				} else {

					dp[(int)(i)][(int)(j)] = dp[(int)(i - 1)][(int)j];

				}

			}

			odd = !odd;

		}

		double p1 = 0.0, p2 = 0.0;

		for(int i = 1; i <= n; ++i) {

			p1 += dp[n][i] * a[i - 1];
			p2 += (1.0 - dp[n][i]) * a[i - 1];

		}

		ans.append(p1).append(" ").append(p2);

		//System.out.printf("%.15f %.15f", p1, p2);

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {

		/*input();
		solve();

		System.out.print(ans.toString());*/

		solver();
		
	}

	private static void solver() throws IOException, FileNotFoundException, NullPointerException {

		fileIO();
		writeFile();

	}

	private static void input(){

		n = in.nextInt();

		a = new double[n];

		for(int i = 0; i < n; ++i) {

			a[i] = in.nextDouble();

		}

	}

	private static void fileIO() throws IOException, NullPointerException, FileNotFoundException {

		FileReader fr = new FileReader(new File("D_Two_Pirates_2.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int visiting = 1;

		while((line = br.readLine()) != null) {

			if(visiting == 1) {

				n = Integer.parseInt(line.trim());

				a = new double[n];

			} else {

				String s[] = line.trim().split(" ");

				for(int i = 0; i < n; ++i) {

					a[i] = Double.parseDouble(s[i]);

				}

				solve();
				return;

			}

			++visiting;

		}

	}

	private static void writeFile() throws FileNotFoundException, IOException, NullPointerException {

		FileWriter fw = new FileWriter(new File("D_Two_Pirates_2.out"));

		fw.write(ans.toString());

		fw.close();

	}

    static void merge(long a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        long L[] = new long[n1];

        long R[] = new long[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(long a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

    static void merge(double a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        double L[] = new double[n1];

        double R[] = new double[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(double a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

}