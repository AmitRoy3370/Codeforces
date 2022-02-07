import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.SysexMessage;

import java.util.HashSet;

public class B_Zero_Array {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        int n = in.nextInt();

        long a[] = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();

        Set<Long> set = new HashSet<>();

        for (long i : a)
            set.add(i);

        if (set.size() == 1) {

            System.out.println("YES");
            return;

        }

        long sum = 0, max = Long.MIN_VALUE;

        int max_index = -1, index = 0;

        for (long i : a) {

            sum += i;

            if (max < i) {

                max = i;
                max_index = index;

            }

            ++index;

        }

        if (sum % 2 == 1) {

            System.out.println("NO");
            return;

        }

        sum = 0;

        for (int i = 0; i < n; i++) {

            if (i != max_index) {

                sum += a[i];

            }

        }

        if (max <= sum)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

}
