import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class B_PolandBall_and_Game {

    static Scanner in = new Scanner(System.in);

    static int n, m;

    static String PolandBall[], EnemyBall[];

    static Set<String> said = new HashSet<>();

    static void solve() {

        if (n > m) {

            System.out.println("YES");
            return;

        } else if (m > n) {

            System.out.println("NO");
            return;

        }

        for (String i : PolandBall)
            said.add(i);

        int dismatch = 0;

        for (String i : EnemyBall)
            if (said.contains(i)) {

                ++dismatch;

            }

        n -= dismatch;
        m -= dismatch;

        if (dismatch % 2 == 1)
            ++n;

        if (n > m)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        m = in.nextInt();

        PolandBall = new String[n];

        EnemyBall = new String[m];

        for (int i = 0; i < n; i++)
            PolandBall[i] = in.next();

        for (int i = 0; i < m; i++)
            EnemyBall[i] = in.next();

        solve();

    }

    static void printSet() {

        for (String i : said)
            System.out.print(i + " ");

        System.out.println();

    }

}

/* 

3 3
ab
bc
cd
cd
df
fg

*/

