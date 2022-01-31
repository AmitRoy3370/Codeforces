import java.util.Scanner;

public class B_Queue {

    static Scanner in = new Scanner(System.in);

    static int n;

    static long a[];

    public static void main(String[] amit) {

        n = in.nextInt();

        a = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();

        /*
         * 
         * our main problem's says us to find the number's or distance between one
         * number and rightmost minimum number's
         * as example if our array is 10,8,5,3,50,45
         * 
         * so for the element 10 the right most minimum is the 3 so distance between
         * them is 2
         * at the same way the distance of the 8 and 5 is 1 and 0
         * 3 is the minimum one it self so it's distance is -1
         * from 50 the right most lowest is the 45 so the distance between them is 0
         * as the same logic the distance of 45 and unknown number -1(which we
         * set/assume as the minimum one of the right sight) is nothing
         * so the answer is -1
         * 
         */

        // firstly we collect the minimum value in the state

        long dp[] = new long[n + 1];

        dp[n - 1] = a[n - 1];

        for (int i = n - 2; i >= 0; i--)
            dp[i] = Math.min(dp[i + 1], a[i]);

        // according to the avibe example our dp array is : 3 3 3 3 45 45 0

        // now we use the binary search to find the minimum element of the every state

        for (int i = 0; i < n; i++) {

            int left = i, right = n;

            while (right -left>1) {

                int mid = (left + right) / 2;

                if (a[i] > dp[mid])
                    left = mid;
                else
                    right = mid;

            }

            System.out.print((left - i - 1) + " ");

        }

    }

}
