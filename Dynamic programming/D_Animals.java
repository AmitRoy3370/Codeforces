
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class D_Animals {

    static Scanner in;

    static int testCases, n, weight;

    static int a[];

    static void solve() {

        int dp[] = new int[weight + 1];

        for (int i = 0; i < n; ++i) {

            int cost = (n - i) * a[i];

            for (int j = weight - cost; j >= 0; --j) {

                dp[j + cost] = Math.max(dp[j] + 1, dp[j + cost]);

            }

        }

        File file = new File("output.txt");

        try {

            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            PrintWriter pw = new PrintWriter(bw);

            pw.println(dp[weight]);

            pw.flush();

            pw.close();

            bw.close();

            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(D_Animals.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] priya) throws IOException {

        read();
        solve();

    }

    static void read() throws IOException {

        File file = new File("input.txt");

        in = new Scanner(file);

        int line = 1;

        while (in.hasNextLine()) {

            if (line == 1) {

                String s[] = in.nextLine().trim().split(" ");

                n = Integer.parseInt(s[0]);
                weight = Integer.parseInt(s[1]);

            } else {

                a = new int[n];

                String s[] = in.nextLine().trim().split(" ");

                for (int i = 0; i < n; ++i) {

                    a[i] = Integer.parseInt(s[i].trim());

                }

                break;

            }

            ++line;

        }

    }

}
