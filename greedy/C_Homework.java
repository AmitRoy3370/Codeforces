
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C_Homework {

    static Scanner in = new Scanner(System.in);

    static char a[];

    static int n, k;

    public static void main(String[] amit) {

        a = in.next().toCharArray();

        n = a.length;

        k = in.nextInt();

        if (k == 0) {

            //System.out.println(n);
            Set<Character> set = new HashSet<>();

            for (char i : a) {
                set.add(i);
            }

            System.out.println(set.size());

            System.out.println(new String(a));

            return;

        }

        Map<Character, Integer> map = new HashMap<>();

        for (char i : a) {

            map.put(i, map.getOrDefault(i, 0) + 1);

        }

        List<characterDetails> list = new ArrayList<>();

        map.keySet().forEach((i) -> {
            list.add(new characterDetails(i, map.get(i)));
        });

        Map<Character, Boolean> exist = new HashMap<>();

        Collections.sort(list);

        /*list.forEach((i) -> {
            System.out.println(i.c+" "+i.count);
        });*/
        StringBuilder ans = new StringBuilder();

        int uniqueCharacter = 0, total = 0;

        for (characterDetails i : list) {

            if (k - map.get(i.c) >= 0) {

                k -= map.get(i.c);

                ++total;

                exist.put(i.c, Boolean.FALSE);

            } else {

                exist.put(i.c, Boolean.TRUE);

            }

        }

        for (int i = 0; i < n; i++) {

            if (exist.get(a[i])) {

                ans.append(a[i]);

            }

        }

        char b[] = ans.toString().toCharArray();

        Set<Character> set = new HashSet<>();

        for (char i : b) {
            set.add(i);
        }

        System.out.println(set.size());

        System.out.println(ans.toString());

    }

    static class characterDetails implements Comparable<characterDetails> {

        char c;
        int count;

        public characterDetails(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(characterDetails t) {
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            return Integer.compare(this.count, t.count);

        }

    }

}
/*

aababcabcdabcde
9

 */
