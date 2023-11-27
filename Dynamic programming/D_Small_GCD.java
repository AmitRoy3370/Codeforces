import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class D_Small_GCD {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, N = (int)(1e5 + 11);
	
	static int a[];
	
	static long dp_num[];
	
	static List<Integer> divisors[];
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		int index = 1;
		
		long dp[] = new long[N];
		
		long ans = 0L;
		
		for(int i : a) {
			
			for(int divisor : divisors[i]) {
				
				ans += (n - index) * dp[divisor];
				
				dp[divisor] += dp_num[divisor];
				
			}
			
			++index;
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		collect_divisors();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
	private static void collect_divisors() {
		
		divisors = new ArrayList[N];
		
		for(int i = 0; i < N; ++i) {
			
			divisors[i] = new ArrayList<>();
			
		}
		
		dp_num = new long[N];
		
		for(int i = 1; i < N; ++i) {
			
			for(int j = i; j < N; j += i) {
				
				divisors[j].add(i);
				
			}
			
			dp_num[i] += i;
			
			for(int j = 2 * i; j < N; j += i) {
				
				dp_num[j] -= dp_num[i];
				
			}
			
		}
		
	}
	
    static void merge(int a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        int L[] = new int[n1];

        int R[] = new int[n2];

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

    static void sort(int a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

}
