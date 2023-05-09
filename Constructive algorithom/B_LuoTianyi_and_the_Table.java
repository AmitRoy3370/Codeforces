import java.util.Scanner;

public class B_LuoTianyi_and_the_Table {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m, len;
	
	static long a[];
	
	static void solve() {
		
		boolean all_equal = true;
		
		for(int i = 0; i < len - 1; ++i) {
			
			if(a[i] != a[i + 1]) {
				
				all_equal = false;
				break;
				
			}
			
		}
		
		if(all_equal) {
			
			System.out.println(0);
			return;
			
		}
		
		sort(a, 0, len - 1);
		
		long max_distance = a[len - 1] - a[0];
		
		long second_max_distance = a[len - 1] - a[1];
		
		long third_max_distance = a[len - 2] - a[0];
		
		int min_visit = Math.min(n, m);
		
		long value = (min_visit - 1) * Math.max(second_max_distance, third_max_distance) + (len - min_visit) * max_distance;
		
		System.out.println(value);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		m = in.nextInt();
		
		len = n * m;
		
		a = new long[len];
		
		for(int i = 0; i < len; ++i) {
			
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

}