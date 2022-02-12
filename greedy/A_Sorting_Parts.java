
import java.util.Scanner;

public class A_Sorting_Parts {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static long a[];

    static void solve() {

        long copyA[] = new long[n];

        System.arraycopy(a, 0, copyA, 0, n);

        sort(copyA, 0, n - 1);

        boolean sorted = true;

        for (int i = 0; i < n; i++) {

            if (a[i] != copyA[i]) {

                sorted = false;

                break;

            }

        }

        if (sorted) {

            System.out.println("NO");

            return;

        }

        System.out.println("YES");

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve();

        }

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

}
/*

3
3
2 2 1
4
3 1 2 1
5
1 2 2 4 4

*/
