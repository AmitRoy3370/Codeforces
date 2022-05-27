import java.util.Scanner;

public class C_Little_Girl_and_Maximum_Sum {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, queries;
	
	static long a[];
	
	static void solve(long left[], long right[]) {
		
		long frequency[] = new long[n];
		
		long diff = 0;
		
		for(int i = 0; i < n; ++i) {
			
			diff += (left[i] - right[i]);
			
			frequency[i] = diff;
			
		}
		
		sort(frequency, 0, n - 1);
		sort(a, 0, n - 1);
		
		long ans = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(frequency[i] <= 0) {
				
				break;
				
			}
			
			ans += frequency[i] * a[i];
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		queries = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		long left[] = new long[n];
		long right[] = new long[n];
		
		for(int i = 0; i < queries; ++i) {
			
			left[in.nextInt() - 1]++;
			
			int r = in.nextInt();
			
			if(r < n ) {
				
				right[r]++;
				
			}
			
		}
		
		solve(left, right);
		
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

            if (L[i] >= R[j]) {

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