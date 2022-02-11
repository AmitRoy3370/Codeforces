import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class B_Cells_Not_Under_Attack {

    static long n, m, x, y, total_Fill = 0, coat, k = 0;

    static Set<Long> raw = new HashSet<>();

    static Set<Long> coloumn = new HashSet<>();

    static Scanner in = new Scanner(System.in);

    static void solve(int i) {

        long ans = (n - raw.size()) * (n - coloumn.size());

        System.out.print(ans + " ");

    }

    public static void main(String[] amit) {

        n = in.nextLong();
        m = in.nextLong();

        coat = n * n;

        for (int i = 0; i < m; i++) {

            x = in.nextLong();
            y = in.nextLong();

            raw.add(x);
            coloumn.add(y);

            solve(i);

        }

    }

}
