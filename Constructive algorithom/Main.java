
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    static int testCases;

    static long n, m;

    static void solve3() {
        
        
    }
    
    static void solve2() {

        n = in.nextLong();
        m = in.nextLong();

        long dis[] = new long[4];

        System.out.println("? 1 1");
        dis[0] = in.nextLong();

        if (dis[0] == 0L) {

            System.out.println("! 1 1");
            return;

        }

        System.out.println("? " + n + " " + m);
        dis[1] = in.nextLong();

        if (dis[1] == 0L) {

            System.out.println("! " + n + " " + m);
            return;

        }

        System.out.println("? " + n + " 1");
        dis[2] = in.nextLong();

        if (dis[2] == 0L) {

            System.out.println("! " + n + " 1");
            return;

        }

        long a = dis[0] + 2L;
        long b = n + m - dis[1];
        long c = dis[2] - n + 1L;

        long y = (c + a) / 2L;

        long x = (y - c);

        x = Math.max(1L, x);
        y = Math.max(1L, y);

        System.out.println("? " + x + " " + y);
        dis[3] = in.nextLong();

        if (dis[3] == 0L) {

            System.out.println("! " + x + " " + y);
            return;

        }

        y = (c + b) / 2L;
        x = (y - c);

        x = Math.max(1L, x);
        y = Math.max(1L, y);

        System.out.println("! " + x + " " + y);

    }

    static void solve1() {

        n = in.nextLong();
        m = in.nextLong();

        long xAxis = 0L, yAxis = 0L;

        long dis[] = new long[4];

        System.out.println("? 1 " + m);

        dis[0] = in.nextLong();

        if (dis[0] == 0L) {

            System.out.println("! " + 1 + " " + m);

            return;

        }

        System.out.println("? " + n + " " + 1);

        dis[1] = in.nextLong();

        if (dis[1] == 0L) {

            System.out.println("! " + n + " 1");

            return;

        }

        System.out.println("? " + n + " " + m);

        dis[2] = in.nextLong();

        if (dis[2] == 0L) {

            System.out.println("! " + n + " " + m);

            return;

        }

        long a = m - dis[0] - 1L;
        long b = dis[1] + 1L - n;
        long c = n + m - dis[2];

        xAxis = (c - a) / 2L;
        yAxis = c - xAxis;

        if (xAxis <= n && yAxis <= m) {

            System.out.println("? " + xAxis + " " + yAxis);

            dis[3] = in.nextLong();

        } else {

            dis[3] = 1L;

        }

        if (dis[3] != 0L) {

            xAxis = (c - b) / 2L;
            yAxis = c - xAxis;

        }

        System.out.println("! " + xAxis + " " + yAxis);

    }

    static void solve() {

        n = in.nextLong();
        m = in.nextLong();

        long dis[] = new long[4];

        System.out.println("? 1 1");
        dis[0] = in.nextLong();

        if (dis[0] == 0L) {

            System.out.println("! 1 1");
            return;

        }

        System.out.println("? " + n + " " + m);
        dis[1] = in.nextLong();

        if (dis[1] == 0L) {

            System.out.println("! " + n + " " + m);
            return;

        }

        System.out.println("? " + 1 + " " + m);
        dis[2] = in.nextLong();

        if (dis[2] == 0L) {

            System.out.println("! " + 1 + " " + m);
            return;

        }

        long a = dis[0] + 2L;
        long b = n + m - dis[1];
        long c = dis[2] - m + 1;

        long x = Math.abs(c + a) / 2L;
        long y = x - c;

        x = Math.min(n, x);
        y = Math.min(y, m);

        if (1L <= x && y <= m) {

            System.out.println("? " + x + " " + y);
            dis[3] = in.nextLong();

        } else {

            dis[3] = 1L;

        }

        if (dis[3] == 0L) {

            System.out.println("! " + x + " " + y);
            return;

        }

        x = Math.abs(c + b) / 2L;
        y = x - c;

        x = Math.min(n, x);
        y = Math.min(m, y);

        System.out.println("! " + x + " " + y);
        //System.out.println("a :- " + a + " b :- " + b + " c :- " + c);

    }

    public static void main(String args[]) {

        testCases = in.nextInt();

        for (int t = 0; t != testCases; ++t) {

            solve();

        }

    }

}
