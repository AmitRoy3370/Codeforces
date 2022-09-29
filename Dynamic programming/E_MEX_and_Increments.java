
import java.util.Scanner;

public class E_MEX_and_Increments {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static int a[];

    /*
    
    for every mex value = x + number that present in the list
    
    here x is some un known number that depends on the previous or all the number of the list
    
    another storage we will keep to store the counting of that number or the which decrease of that number
    for which value
    
    value of the x is i - 1 - have[--counting]
    
     */
    static void solve() {

        int count[] = new int[n + 1];

        for (int i : a) {

            count[i]++;

        }

        long dp[] = new long[n + 1];

        for (int i = 0; i <= n; ++i) {

            dp[i] = -1L;

        }

        long x = 0L;

        int counting = 0;

        int have[] = new int[n];

        for (int i = 0; i <= n; ++i) {

            if (i > 0) {

                if (counting == 0) {

                    break;

                }

                x += i - 1 - have[--counting];

            }

            dp[i] = x + count[i];

            while (count[i]-- > 0) {

                have[counting++] = i;

            }

        }

        // O(n * maximum_count)
        for (long i : dp) {

            System.out.print(i + " ");

        }

        System.out.println();

        /*for(int i : have) {
            
            System.out.print(i + " ");
            
        }
        
        System.out.println();*/
    }

    public static void main(String[] Priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextInt();

            a = new int[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextInt();

            }

            solve();

        }

    }

}
/*

1
7
0 1 2 3 4 3 2

 */

 /*

1
5
4 0 1 0 4

 */
