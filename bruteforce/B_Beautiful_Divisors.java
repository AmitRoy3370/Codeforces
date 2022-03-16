
import java.util.Scanner;

public class B_Beautiful_Divisors {

    static Scanner in = new Scanner(System.in);

    static int n;

    static void solve() {

        for (int i = n; i >= 2; --i) {

            if (n % i == 0 && isBeutifull(i)) {

                System.out.println(i);
                return;

            }
        }

        //System.out.println(isBeutifull(496));
        System.out.println(1);

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        solve();

    }

    static boolean isBeutifull(int n1) {

        StringBuilder bin = new StringBuilder();

        int copy_of_orginal = n1;

        while (n1 > 0) {

            bin.append((n1 % 2));

            n1 /= 2;

        }

        bin.reverse();

        //System.out.println("bin format : " + bin.toString() + " " + copy_of_orginal);
        char a[] = bin.toString().toCharArray();

        int m = a.length;

        for (int i = 0; i < m; ++i) {

            int count_one = 0, count_zero = 0;

            if (i < m && a[i] - '0' == 1) {

                while (i < m && a[i] - '0' == 1) {

                    ++i;
                    ++count_one;

                }

            }

            if (i < m && a[i] - '0' == 0) {

                while (i < m && a[i] - '0' == 0) {

                    ++i;
                    ++count_zero;

                }

            }

            //System.out.println("count_zero : " + count_zero + " count_one : " + count_one);
            if (Math.abs(count_zero - count_one) >= 1) {

                int y = Math.max(count_zero, count_one);

                int get = (int) (Math.pow(2, y) - 1) * (int) Math.pow(2, y - 1);

                //System.out.println("get : " + get);
                if (get == copy_of_orginal) {

                    return true;

                }

            }

        }

        return false;

    }

}
