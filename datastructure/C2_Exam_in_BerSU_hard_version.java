
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class C2_Exam_in_BerSU_hard_version {
		
    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

	static int n, m;
	
	static int a[];
	
	static void solve() {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			long reminder = m - a[i];
			
			long count = 0;
			
			for(int j = 1; j < 101; ++j) {
			
              if(map.getOrDefault(j, 0) != 0) {  			
				
				long av = Math.min(map.get(j), reminder / j);
				
				count += av;
				
				reminder -= j * av;
			  
			  }	
				
			}
			
			count = i - count;
			
			System.out.print(count + " ");
			
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
			
		}
		
	}
	
	public static void main(String [] amit) throws IOException {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
		in.close();
		
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