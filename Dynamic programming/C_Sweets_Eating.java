import java.util.Scanner;

public class C_Sweets_Eating {
	
	static Scanner in = new Scanner(System.in);
	
	static long a[];
	
	static int n, m, testCases;
	
	static void solve() {
		
		long dp[] = new long[n + 1];
		
		sort(a, 0, n);
		
		long sum = 0L;
		
		for(int i = 1; i <= n; ++i) {
			
			sum += a[i];
			
			dp[i] = sum;
			
			if(i - m >= 0) {
				
				dp[i] += dp[i - m];
				
			}
			
		}
		
		print(dp);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			a = new long[n + 1];
			
			for(int i = 1; i <= n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
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
	
	static void print(long a[]) {
		
		int index = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(long i : a) {
			
			if(index == 0) {
				
				++index;
				
				continue;
				
			}
			
			//System.out.print(i + " ");
			
			sb.append(i).append(" ");
			
			++index;
			
		}
		
		System.out.print(sb.toString());
		
	}

} 