
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class D_Divide_and_Summarize{
	
    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static long a[];
	
	static int testCases, n, queries;
	
	static Map<Long, Boolean> map = new HashMap<>();
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int left, int right) {
		
		long sum = 0;
		
		for(int i = left; i <= right; ++i) {
			
			sum += a[i];
			
		}
		
		map.put(sum, true);
		
		long mid = (a[left] + a[right] ) / 2;
		
		int position = -1;
		
		for(int i = left; i <= right; ++i) {
			
			if(a[i] <= mid) {
				
				position = i;
				
			}else {
				
				break;
				
			}
			
		}
		
		if(position == -1 || position >= right ) {
			
			return;
			
		}
		
		solve(left, position);
		solve(position + 1, right );
		
	}

    static void solve() throws IOException {
		
		map = new HashMap<>();
		
		solve(0, n - 1);
		
		for(int i = 0; i < queries; ++i) {
			
			long summation = in.nextLong();
			
			if(map.containsKey(summation) ){
				
				ans.append("YES").append("\n");
				
			}else {
				
				ans.append("NO").append("\n");
				
			}
			
		}
		
	}

	public static void main(String [] priya) throws IOException {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			queries = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			sort(a, 0, n - 1);
			
			solve();
			
		}
		
		out.println(ans.toString());
		out.flush();
		
		in.close();
		
	}
	
    static void merge(long a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        long L[] = new long[n1];

        long R[] = new long[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(long a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

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