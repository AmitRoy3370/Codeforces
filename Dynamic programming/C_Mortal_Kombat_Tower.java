
import java.util.Scanner;

public class C_Mortal_Kombat_Tower {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static int a[];

    /*
    
    1
    8
    1 0 1 1 0 1 1 1
    
    manual solution: 
    
    lower dot is mention my friend and upper dot is mention me.
    
        ...    .... 
    1 0 1 1 0 1 1 1
    ...     ...
    1        2      -> skip 2 case
    
    dp solution:
    ............
    
    we have 4 possibility either we can take the present
    one value or we can take the present 
    with the recent previous
    one. Or we can skip this present value and
    take the previous one value or we can 
    take skip the present value
    and take the previous two values.
    So, we can solve it using 2d state dp.
    the first index of the dp mention or we
    store at here the value is taken by friend
    that means it will find the minimum of 
    the take the present one value or we
    will take the present value with the 
    recent previous value. And the 2nd index
    of our dp table will store the value if we
    skip our present index value and take previous
    one as my action or we will take the previous
    two as our action. Mainly this will collect the
    minimum amount among this both of them
    
    so our dp state is : 
    dp[i][0] = min(dp[i - 1][1] + a[i], dp[i - 2] + a[i] + a[i - 1])
    dp[i][1] = min(dp[i - 1][0], dp[i - 2][1])
    
    This is mainly top to bottom dp
    so our ans will store at the final
    state of our dp table. Here the every
    index will mention the length of the element
    we take till now.
    

    dp table
    .........
    
    |---|---|---|---|---|---|---|---|---|-
    |in | 0 | 1 | 1 | 1 | 1 | 2 | 2 | 2 |
    |---|---|---|---|---|---|---|---|---|-
    |0  |in | 0 | 0 | 1 | 1 | 1 | 1 | 2 | -> so, our valid ans is 2 or my friend can have 2 skip point
    |---|---|---|---|---|---|---|---|---|-
    
    greedy solution:
    .................
    
    This is quite simple than dp, here for the value 0
    we can directly skip that as no effect will fail
    due to this value of the 0
    And we will count that how many
    consequtive 1 is situted in a raw
    then just we count the prev state to
    present states every 2 value for me
    and give one for my friend
    our next iterate value or position
    will be the next of that state
    
    time complexity of the both solution is O(N)
    and the space complexity of the both solution
    is O(n) also.
    
     */
    static void solve() {

        if (n == 1) {

            int ans = (a[0] == 1 ? 1 : 0);

            System.out.println(ans);

            return;

        } else if (n == 2) {

            int bin[] = new int[2];

            for (int i : a) {

                bin[i]++;

            }

            switch (bin[1]) {
                case 3:
                    System.out.println(a[0]);
                    break;
                case 2:
                    System.out.println(a[0]);
                    break;
                case 1:
                    System.out.println(a[0]);
                    break;
                default:
                    System.out.println(0);
                    break;
            }

            return;

        }

        int dp[][] = new int[n + 1][2];

        // index 0 is for take the two value for my friend
        // index 1 is for the between two previous value that means present value is taken by me
        dp[0][0] = (int) 1e9;// initially we have not any value behind and for the another index
        // the value is 0 that means we do not take any value

        dp[1][0] = a[0];// when we take only one value then the value is the first value as the first move is 
        //for my friend
        dp[1][1] = (int) 1e9;// in the behind we have not any value

        // there is two state on is we take 1 present value for my friend or we take present value and the previous
        // value for my friend. This is in 0th index. Another possibility is we skip the present value or it is taken 
        // by me
        // we will take either the previous one value for my friend or the previous two value for my friend
        for (int i = 2; i <= n; ++i) {

            dp[i][0] = Math.min(dp[i - 1][1] + a[i - 1], dp[i - 2][1] + a[i - 1] + a[i - 2]);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 2][0]);

        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));

        //print(dp);
    }

    static void greedy() {

        int ans = a[0];

        for (int i = 1; i < n; ++i) {

            if (a[i] == 0) {

                continue;

            }

            int j = i;

            while (j < n && a[j] == 1) {

                ++j;

            }

            ans += (j - i) / 3;

            i = j - 1;

        }

        System.out.println(ans);

    }

    public static void main(String[] priya) {

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

    static void print(int dp[][]) {

        for (int i[] : dp) {

            for (int j : i) {

                System.out.print(j + " ");

            }

            System.out.println();

        }

    }

}
/*

1
8
1 0 1 1 0 1 1 1

 */

 /*

1
5
1 1 1 1 0

 */

 /*

1
6
1 1 1 1 1 1

 */

 /*

1
2
1 0

 */

 /*

1
4
0 1 1 1

 */
