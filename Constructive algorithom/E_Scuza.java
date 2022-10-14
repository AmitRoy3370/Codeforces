import java.util.Scanner;

public class E_Scuza {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, q;
	
	static long a[], k[];
	
	static void solve() {
		
		long height[] = new long[q];
		
		element legs[] = new element[q];
		
		for(int i = 0; i < q; ++i) {
			
			legs[i] = new element(k[i], i);
			
		}
		
		sort(legs, 0, q - 1);
		
		int j = 0;
		
		long high = 0L;
		
		for(int i = 0; i < q; ++i) { // O(q)
			
			//long high = 0L;
			
			long leg = legs[i].value;
			int index = legs[i].index;
			
			while(j < n) { // o(n)
				
				if(a[j] > leg) {
					
					break;
					
				}
				
				high += a[j];
				
				++j;
				
			}
			
			height[index] = high;
			
		}
		
		print(height);
		
	}
	
	static void solve_bruteforce() {
		
		long height[] = new long[q];
		
		for(int i = 0; i < q; ++i) { // O(q)
			
			long high = 0L;
			
			for(int j = 0; j < n; ++j) { // o(n)
				
				if(a[j] > k[i]) {
					
					break;
					
				}
				
				high += a[j];
				
			}
			
			height[i] = high;
			
		}
		
		//O(qn)
		
		print(height);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			q = in.nextInt();
			
			a = new long[n];
			
			k = new long[q];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < q; ++i) {
				
				k[i] = in.nextLong();
				
			}
			
			//solve_bruteforce();
			solve();
			
		}
		
	}
	
	static void print(long height[]) {
		
		for(long i : height) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
	static class element {
		
		long value;
		int index;
		
		public element(long value, int index) {
			
			this.value = value;
			this.index = index;
			
		}
		
	}
	
    static void merge(element a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        element L[] = new element[n1];

        element R[] = new element[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i].value <= R[j].value) {

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

    static void sort(element a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

}