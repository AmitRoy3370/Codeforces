import java.util.Scanner;

public class A_Towers {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static int a[];
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		int duplicate = 1, number = 0;
		
		for(int i = 0; i < n; ++i) {
			
			int dup = 1;
			
			while(i + 1 < n && a[i] == a[i + 1]) {
				
				++dup;
				
				++i;
				
			}
			
			duplicate = Math.max(dup, duplicate);
			
			++number;
			
		}
		
		System.out.println(duplicate + " " + number);
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
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