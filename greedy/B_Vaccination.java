import java.util.Scanner;

public class B_Vaccination {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k, d, w;
	
	static long a[];
	
	static void solve() {
		
		//sort(a, 0, n - 1);
		
		//print(a);
		
		int vaccine = 0;
		
		long vaccine_time = a[0] + w + d;
		
		int p = k;
		
		for(int i = 0; i < n; ++i) {
			
			if(vaccine_time >= a[i] && k >= 1) {
				
				--k;
				
			} else {
				
				k = p - 1;
				
				++vaccine;
				
			    long start_time = a[i];
			
			    long end_time = a[i] + w;
			
			    vaccine_time = end_time + d;
			
			}
			
		}
		
		++vaccine;
		
		System.out.println(vaccine);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			k = in.nextInt();
			d = in.nextInt();
			w = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
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
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}

}