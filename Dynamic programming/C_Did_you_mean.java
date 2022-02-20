import java.util.Scanner;

public class C_Did_you_mean {

    static Scanner in = new Scanner(System.in);

    static int n;

    static char message[];

    static void solve() {

        boolean letters[] = new boolean[26];

        char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        //Set<Character> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {

            if (alphabet[i] != 'a' && alphabet[i] != 'e' && alphabet[i] != 'i' && alphabet[i] != 'o'
                    && alphabet[i] != 'u') {

                letters[alphabet[i] - 'a'] = true;

            }

        }

        StringBuilder ans = new StringBuilder();

        int comsonant = 0;

        for (int i = 0; i < n; i++) {

            if (letters[message[i] - 'a']) {

                comsonant++;

            } else
                comsonant = 0;

            if (comsonant >= 3 && (message[i] != message[i - 1] || message[i] != message[i - 2])) {
                ans.append(" ").append(message[i]);
                comsonant = 1;

            } else
                ans.append(message[i]);

        }

        System.out.println(ans.toString());

    }

    public static void main(String[] amit) {

        message = in.next().toCharArray();

        n = message.length;

        solve();

    }

}

// bababcdfabbcabcdfacbbabcdfacacabcdfacbcabcdfaccbabcdfacaaabcdfabacabcdfabcbabcdfacbaabcdfabaaabcdfabbaabcdfacababcdfabbbabcdfabcaabcdfaaababcdfabccabcdfacccabcdfaacbabcdfaabaabcdfaabcabcdfaaacabcdfaccaabcdfaabbabcdfaaaaabcdfaacaabcdfaacc
// heffffffgggggghhhhhh