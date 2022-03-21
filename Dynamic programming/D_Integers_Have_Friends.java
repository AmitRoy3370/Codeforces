
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_Integers_Have_Friends {
		
    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	static int n, testCases;
	
	static long a[];
	
	static StringBuilder finalAns = new StringBuilder();
	
	static void solve() {
		
		long dp[] = new long[n];
		
		for(int i = 1; i < n; ++i) {
			
			dp[i] = Math.abs(a[i] - a[i - 1]);
			
		}
		
		long ans = 1, gcd = 0, count = 1;
		
		for(int i = 1; i < n; ++i) {
			
			gcd = gcd(gcd, dp[i]);
			
			if(gcd == 1 ) {
				
				gcd = 0;
				count = 1;
				
				for(int j = i; j >= 1; --j) {
					
					long temp = gcd(gcd, dp[j]);
					
					if(temp == 1 ) {
						
						break;
						
					} else {
						
						gcd = temp;
						++count;
						
					}
					
				}
				
			} else {
				
				++count;
				
				ans = Math.max(ans, count);
				
			}
			
		}
		
		finalAns.append(ans).append("\n");
		
	}
	
	public static void main(String [] priya) throws IOException {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
		out.print(finalAns.toString());
		out.flush();
		
	}
		
    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
	
    static class Scanner {

        BufferedReader in;
        StringTokenizer st;

        public Scanner() {

            in = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() throws IOException {

            while (st == null || !st.hasMoreElements()) {

                st = new StringTokenizer(in.readLine());

            }

            return st.nextToken();

        }

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        String nextLine() throws IOException {

            return in.readLine();

        }

        char nextChar() throws IOException {

            return next().charAt(0);

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        float nextFloat() throws IOException {

            return Float.parseFloat(next());

        }

        boolean nextBoolean() throws IOException {

            return Boolean.parseBoolean(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

}