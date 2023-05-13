import java.util.Scanner;

public class B_Maximum_Sum {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void dp() {
		
		long max_sum = 0L;
		
		sort(a, 0, n - 1);
		
		long sum = 0L;
		
		long prefix[] = new long[n + 1];
		
		prefix[0] = a[0];
		
		for(int i = 1; i < n; ++i) {
			
			prefix[i] = prefix[i - 1] + a[i];
			
		}
		
		int i = 2 * k - 1, j = n - 1;
		
		sum = prefix[n - 1 - k];
		
		while(i >= 0) {
			
			sum = Math.max(sum, prefix[j] - prefix[i]);
			
			i -= 2;
			--j;
			
		}
		
		System.out.println(sum);
		
	}
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		int min_index = 0, max_index = n - 1;
		
		long sum = 0L;
		
		for(long i : a) {
			
			sum += i;
			
		}
		
		long dp[][] = new long[k][2];
		
		/*
		
		here our dp has two state, one state is for the 
		first operation, other state is for the second
		operation.
		
		*/
		
		//initialize state.
		
		dp[0][0] = a[0] + a[1];//take the minimum two
		dp[0][1] = a[n - 1];//take the maximum one
		
		int j = 2, k1 = n - 2;
		
		for(int i = 1; i < k; ++i) {
			
			long min_sum = a[j] + a[j + 1];
			
			long max_sum = a[k1];
			
			dp[i][0] = Math.min(dp[i - 1][0] + min_sum, dp[i - 1][1] + dp[i - 1][0]);
			
			dp[i][1] = Math.min(dp[i - 1][0] + dp[i - 1][1], dp[i - 1][1] + max_sum);
			
			j += 2;
			k1--;
			
			/*if(j >= k1) {
				
				break;
				
			}*/
			
		}
		
		/*if(k - 2 >= 0 && dp[k - 1][0] == 0 || dp[k - 1][1] == 0) {
			
			dp[k - 1][0] = dp[k - 2][0];
			dp[k - 1][1] = dp[k - 2][1];
			
		}*/
		
		sum -= Math.min(dp[k - 1][0], dp[k - 1][1]);
		
		System.out.println(sum);
		
		//print(dp);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			dp();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
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
	
	private static void print(long dp[][]) {
		
		for(long i[] : dp) {
			
			for(long j : i) {
				
				System.out.print(j + " ");
				
			}
			
			System.out.println();
			
		}
		
	}

}

/*

1
8 2
684528253 760200471 201993786 755136637 863169941 534733439 423767550 153437085

*/

/*

1
9 3
1 2 5 7 10 12 12 12 14

*/

/*

1
9 4
4 4 4 4 5 6 7 7 7

*/