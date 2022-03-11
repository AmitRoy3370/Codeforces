
import java.util.Scanner;

public class B_Petya_and_Countryside {

    static Scanner in = new Scanner(System.in);

    static int n;

    static int a[];

    static void solve() {

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {

            int j = i, count = 0;

            while (j - 1 >= 0 && a[j] >= a[j - 1]) {

                ++count;
                --j;

            }

            count++;

            j = i;

            int count1 = 0;

            while (j + 1 < n && a[j] >= a[j + 1]) {

                ++count1;
                ++j;

            }

            //count1++;
            j = i;

            count += count1;

            //System.out.println("count for i: "+i+" "+count);
            ans = Math.max(ans, count);

        }

        System.out.print(ans);

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        a = new int[n];

        for (int i = 0; i < n; ++i) {

            a[i] = in.nextInt();

        }

        solve();

    }

}
/*

1
2


 */

 /*

5
1 2 1 2 1

 */

 /*

8
1 2 1 1 1 3 3 4


 */

/*

5
4 2 3 3 2

*/
