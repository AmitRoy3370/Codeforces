import java.util.Scanner;

public class J_Missing_Coin_Sum {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		sort(a, 0, n - 1);
		
		if(a[0] != 1) {
			
			System.out.println(1);
			
		} else {
			
			long ans = 1;
			
			for(int i = 1; i < n; ++i) {
				
				if(ans + 1 >= a[i]) {
					
					ans += a[i];
					
				} else {
					
					break;
					
				}
				
			}
			
			System.out.println(++ans);
			
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