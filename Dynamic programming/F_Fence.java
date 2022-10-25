
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class F_Fence {

    static int n, red, green;

    static int height[];

    /*
    
    Main requirement: Here we have n fences and a fix number of red and the green color. Our every brush
    ..................
    is 1 cm in width. Our un wanted condition is two 1 cm cell of two consequtive fence have the different 
    color. So every fence we have to divede the every 1 cm cell. We can paint in the fence either only
    red or the green or both of course not going the fixed level, and main target is to minimize the
    un wanted condition. Here an another important observation is in one fence we can use only one color
    among two of them.Here we also habe to determine that if it is impossible to paint all the fence.
    
    Solving example manually:
    .........................
    
    solve eg1:
    
    4 -> number of monster
    5 7 -> number of red color and the number of the green color
    3   3   4   1 -> height's of the each fence
    
            r
    g   g   r
    g   g   r
    g   g   r   r
    
      0   3   0      -> total un wanted = 3  
    
    solve eg2:
    
    3 -> number of the monster
    2 3 -> number of red and the number of the green color
    1   3   1 -> height's of the each fence
    
        g
        g
    r   g   r
    
      1   1     -> total un wanted = 2  
    
    eg3:
    
    3 -> number of fence
    3 3 -> number of the color of the red and blue color
    2   2   2 -> height's of the each fence
    
    g   r   r
    g   r   g
    
    which is impossible to paint all the fence.
    
    Observations:
    .............
    
    * at every state we have two state either we can take the present fence height or skiping one by one
      cell and take from the previous state's.
    * So, according to that condition's we can use 2d dp / 2 state dp.
    * Have to choose the minimum one height among the two consequtive fence, and choose them as the coloring
      state / fence.
    * At every state we have to calculate this same thing is this color is fit for this place or not.
    
     */
    static void solve() throws IOException {

        StringBuilder ans = new StringBuilder();

        int maximum_height = 0;

        for (int i : height) {

            maximum_height += i;

        }

        long dp[][] = new long[(maximum_height) + 1][2];

        for (int i = 0; i <= maximum_height; ++i) {

            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;

        }

        dp[0] = new long[]{0L, 0L};

        int height_sum = 0;

        for (int i = 0; i < n; ++i) {

            int consequtive_two_min_height = i == 0 ? height[0] : Math.min(height[i - 1], height[i]);

            for (int j = height[i] + height_sum; j >= 0; --j) {

                long green_color = dp[j][0] + consequtive_two_min_height;
                long red_color = dp[j][1];

                dp[j][1] = Math.min(green_color, red_color);

                green_color = (j - height[i] < 0) ? Integer.MAX_VALUE : dp[j - height[i]][0];
                red_color = (j - height[i] < 0) ? Integer.MAX_VALUE : dp[j - height[i]][1] + consequtive_two_min_height;

                dp[j][0] = Math.min(green_color, red_color);

            }

            height_sum += height[i];

        }

        //print(dp);
        long cost = Integer.MAX_VALUE;

        for (int i = 0; i <= height_sum; ++i) {

            if (i <= red && height_sum - i <= green) {

                cost = Math.min(cost, Math.min(dp[i][0], dp[i][1]));

                if (cost > maximum_height) {

                    cost = -1L;
                    break;

                }

            }

        }

        if(cost == Integer.MAX_VALUE) {
            
            cost = -1;
            
        }
        
        ans.append(cost).append("\n");

        //System.out.println("cost : " + cost);
        File file = new File("output.txt");

        try {

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.print(ans.toString());
            pw.flush();
            pw.close();
            fw.close();
            bw.close();

        } catch (IOException e) {

        }

    }

    public static void main(String[] priya) throws FileNotFoundException, IOException {

        read();
        solve();

    }

    static void read() throws FileNotFoundException {

        File file = new File("input.txt");

        Scanner in = new Scanner(file);

        int line = 1;

        while (in.hasNextLine()) {

            switch (line) {
                case 1:
                    n = Integer.parseInt(in.nextLine().trim());
                    break;
                case 2: {
                    String s[] = in.nextLine().trim().split(" ");
                    red = Integer.parseInt(s[0].trim());
                    green = Integer.parseInt(s[1].trim());
                    break;
                }
                default: {
                    height = new int[n];
                    String s[] = in.nextLine().trim().split(" ");
                    for (int i = 0; i < n; ++i) {

                        height[i] = Integer.parseInt(s[i].trim());

                    }
                    break;
                }
            }

            ++line;

        }

    }

    static void print(long dp[][]) {

        for (long i[] : dp) {

            for (long j : i) {

                System.out.print(j + " ");

            }

            System.out.println();

        }

    }

}
