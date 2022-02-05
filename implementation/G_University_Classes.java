import java.util.Scanner;

public class G_University_Classes {

    static Scanner in = new Scanner(System.in);

    static int n;

    static char groups[][];

    public static void main(String[] amit) {

        n = in.nextInt();

        groups = new char[n][7];

        for (int i = 0; i < n; i++)
            groups[i] = in.next().toCharArray();

        int ans = 0;

        for (int i = 0; i <= 6; i++) {

            // boolean ok = true;

            int count = 0;

            for (int j = n - 1; j >= 0; j--) {

                /*if (groups[j][i] == '0') {

                    ans = Math.max(count, ans);
                    count = 0;

                    if (j == 0)
                        break;

                }*/

                if (groups[j][i] == '1')
                    ++count;

            }

            // System.out.println("ans: "+ans);

            // if (count == n)
            ans = Math.max(count, ans);

        }

        if (ans >= 1) {

            System.out.println(ans);

        } else {

            System.out.println(0);

        }

    }

}
/*
 * 
 * 5
 * 0100101
 * 0000001
 * 0110000
 * 0010000
 * 0011110
 * 
 */