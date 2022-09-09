import java.util.Scanner;

public class B_Basketball_Together {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long D;
	
	static long a[];
	
	static void solve() {
		
		sort(a, 0, n);
		
		int i = 1, j = n;
		
		int team = 0;
		
		while(true) {
			
			long x = a[j];
			
			if(x > D) {
				
				j--;
				
				++team;
				
				if(j <= 0) {
					
					break;
					
				}
				
				continue;
				
			}
			
			long temp = D / x + 1;
			
			if(i + temp - 1 > j) {
				
				break;
				
			} else {
				
				i = i + (int)temp - 1; 
				--j;
				++team;
				
			}
			
			if(i > n) {
				
				break;
				
			}
			
		}
		
		System.out.println(team);
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		D = in.nextLong();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		solve();
		
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

/*

2 3
1 2

*/