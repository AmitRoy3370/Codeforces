import java.util.Scanner;

public class D_Friends_and_the_Restaurant {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long x[], y[];
	
	static void solve() {
		
		Solve a[] = new Solve[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = new Solve(x[i], y[i]);
			
		}
		
		sort(a, 0, n - 1);
		
		/*for(Solve i : a) {
			
			System.out.println(i.toString());
			
		}*/
		
		int first_corner = 0, last_corner = n - 1;
		
		int team = 0;
		
		while(first_corner >= 0 && last_corner < n && first_corner < last_corner) {
			
			if(a[first_corner].diff + a[last_corner].diff < 0) {
				
				++first_corner;
				
			} else {
				
				++first_corner;
				--last_corner;
				++team;
				
			}
						
		}
		
		System.out.println(team);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			x = new long[n];
			y = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				x[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				y[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static class Solve {
		
		long need, have, diff;
		
		public Solve(long need, long have) {
			
			this.need = need;
			this.have = have;
			this.diff = have - need;
			
		}
		
		public String toString() {
			
			return this.need + " " + this.have + " " + this.diff;
			
		}
		
	}
	
	static int comparator(Solve x, Solve y) {
		
		if(x.diff > y.diff) {
			
			return 1;
			
		} else if(x.diff < y.diff) {
			
			return -1;
			
		}
		
		return 0;
		
	}
		
    static void merge(Solve a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        Solve L[] = new Solve[n1];

        Solve R[] = new Solve[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (/*L[i] <= R[j]*/comparator(L[i], R[j]) <= 0 ) {

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

    static void sort(Solve a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }
	
}