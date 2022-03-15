
import java.util.Scanner;

public class C_Number_of_Ways {

    static Scanner in = new Scanner(System.in);

    static int n;

    static long a[];

    static void solve() {

    }

    public static void main(String[] amit) {

        n = in.nextInt();

        a = new long[n];

        long sum = 0;

        for (int i = 0; i < n; ++i) {

            a[i] = in.nextLong();
            sum += a[i];

        }

        if (sum % 3 != 0) {

            System.out.println(0);
            return;

        }

        sum /= 3;

        long reverse_consiqutive_sum = 0;

        int count[] = new int[n];

        for (int i = n - 1; i >= 0; --i) {

            reverse_consiqutive_sum += a[i];

            if (reverse_consiqutive_sum == sum) {

                count[i] = 1;

            }

        }

        for (int i = n - 2; i >= 0; --i) {

            count[i] += count[i + 1];

        }

        long front_consiqutive_sum = 0, ans = 0;

        for (int i = 0; i < n - 2; ++i) {

            front_consiqutive_sum += a[i];

            if (front_consiqutive_sum == sum) {

                ans += count[i + 2];

            }

        }

        System.out.println(ans);

    }

}
