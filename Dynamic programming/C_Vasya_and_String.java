import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class C_Vasya_and_String {

    static Scanner in = new Scanner(System.in);

    static int length, can_change;

    static char birthday_present[];

    static void solve() {

        /*
         * 
         * Here we have to detect the maximum number of unique length substring present
         * in that birthday present text.which contains only
         * 'a' and 'b'.To gain the maximum length we can highest do the k number of
         * changes.
         * as we have to detect the substring so we guess that our substring start from
         * the left most index
         * untile the minimum count f the 'a' and 'b' is in the limit of the k the
         * highest number of change we can perform our operation
         * and make string consequtive on that fixed substring range.So for the
         * implementation we increase our perfect length of the unique
         * substring. As we can change the minimum one and make the string butify
         * according to that condition.
         * if some dismatch happen it means the minimum count of the 'a' and 'b' reach
         * the out of the limit of the k.
         * then we increase our value of the left which will represented as the left
         * most corner of the satisfied substring.
         * and also dicrease the count of that left most character. If the minimum count
         * of the 'a' and 'b' reach the satisfied level again
         * then we also increase our answer as from the left most corner of the
         * satisfied substring there present an another satisfied substring
         * 
         */

        int ans = 0, left = 0;// here ans represented the satisfied substring length and left represented as
                              // the left most corner of the satisfied substring

        int count[] = new int[2];// this will continue the count of the string's character

        for (int i = 0; i < length; i++) {

            count[birthday_present[i] - 'a']++;

            if (Math.min(count[0], count[1]) <= can_change)// check that the range of the changing level is in the range
                                                           // or not
                ++ans;// if satisfied avobe consition increase the length of the substring
            else
                count[birthday_present[left++] - 'a']--;// other wise change or increase the left most corner of the
                                                        // satisfied substring

        }

        System.out.println(ans);

    }

    public static void main(String[] amit) {

        length = in.nextInt();

        can_change = in.nextInt();

        birthday_present = in.next().toCharArray();

        solve();

    }

}
