import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class A_Ladder {

	static int n;

	static long a[];

	static void solve() throws IOException {

		long ans = Long.MIN_VALUE;

		if(n == 1) {

			ans = a[0];

		} else {

			long dp[] = new long[n + 1];

			dp[0] = 0L;

			for(int i = 1; i <= n; ++i) {

				dp[i] = Long.MIN_VALUE;

			}

			boolean get_last = false;
			
			for(int i = 1; i <= n; ++i) {

				if(i - 2 >= 0) {

				   dp[i] = Math.max(a[i - 1] + dp[i - 1], Math.max(dp[i], dp[i - 2] + a[i - 1]) );
			    
			    } else {

			    	dp[i] = Math.max(dp[i], dp[i - 1] + a[i - 1]);

			    }

			}

			ans = dp[n];

		}

		String fileName = "ladder.out";

		FileWriter fw = new FileWriter(new File(fileName) );

		fw.write(ans+ "");

		fw.close();

	}

	public static void main(String[] priya) throws Exception {

		input();
		solve();
		
	}

	private static void input() throws IOException {

		//a = new long[n];

		String fileName = "ladder.in";

		FileReader reader = new FileReader(new File(fileName));
        BufferedReader bufferedReader = new BufferedReader(reader);
            
            String line;

            int i = 1;
            while ((line = bufferedReader.readLine()) != null) {
                
                if(i == 1) {

                	n = Integer.parseInt(line.trim());

                	a = new long[n];

                	//System.out.println(n);

                } else {

                	String s[] = line.split(" ");

                	//System.out.println(line + "\n" + a.length);

                	for(int i1 = 0; i1 < n; ++i1) {

                		a[i1] = Long.parseLong(s[i1]);

                	}

                	break;

                }

                ++i;
            
            }

            bufferedReader.close();
		
	}
	
}