
import java.util.Scanner;

public class C_Painting_Fence extends Thread {

    static int n;

    static long a[];

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        new Thread(null, new C_Painting_Fence(), "Main", 1 << 28).start();

    }

    @Override
    public void run() {
        // To change body of generated methods, choose Tools | Templates.

        n = in.nextInt();

        a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }

        System.out.println(solve(a, 0, n, 0));

        /*
         * for (long i : a) {
         * System.out.print(i + " ");
         * }
         */
    }

    static int solve(long a[], int left, int right, long middleElement) {

        //System.out.println("left: "+left+" right: "+right);

        if (left >= right) {

            return 0;

        }

        int minIndex = findMinIndex(a, left, right);

        return (int) Math.min(right - left, a[minIndex] - middleElement + solve(a, left, minIndex, a[minIndex])
                + solve(a, minIndex + 1, right, a[minIndex]));

    }

    static int findMinIndex(long a[], int left, int right) {

        int index = -1;

        long min = Long.MAX_VALUE;

        for (int i = left; i < right; i++) {

            if (a[i] != 0 && a[i] < min) {

                min = a[i];
                index = i;

            }

        }

        return index;

    }

    static int findMaxIndex(long a[], int left, int right) {

        int index = -1;

        long min = Long.MIN_VALUE;

        for (int i = left; i < right; i++) {

            if (a[i] != 0 && a[i] > min) {

                min = a[i];
                index = i;

            }

        }

        return index;

    }

    static void resizeArray(long a[], int left, int right) {

        for (int i = left; i <= right; i++) {

            if (a[i] != 0) {
                a[i]--;
            }

        }

    }

    static int countZero(long a[], int left, int right) {

        int count = 0;

        for (int i = left; i <= right; i++) {

            if (a[i] == 0) {

                ++count;

            }

        }

        return count;

    }

}
/*
 * 
 * 5
 * 2 2 1 2 1
 * 
 */

/*
 * 
 * 2
 * 2 2
 * 
 */

/*
 * 
 * 1
 * 5
 * 
 */
