import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class A_Dreamoon_and_Ranking_Collection {

    static Scanner in = new Scanner(System.in);

    static int testCases, n, x;

    static int a[];

    static void solve() {

        List<Integer> list = new ArrayList<>();

        for (int i : a)
            list.add(i);

        int ans = 0;

        while (x >= 0) {

            ++ans;

            if (!list.contains(ans))
                --x;

            // ++ans;

        }

        System.out.println(ans-1);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {

            n = in.nextInt();

            x = in.nextInt();

            a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();

            solve();

        }

    }

}
