import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class C_Quiz_Master {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, m, n;
	
	static long a[];
	
	static List<Long> list[];
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		int left = 0, right = -1, get = 0;
		
		long min_diff = Integer.MAX_VALUE;
		
		int count[] = new int[m + 7];
		
		while(true) {
			
			if(get >= m) {
				
				min_diff = Math.min(min_diff, a[right] - a[left]);
				
				for(long divisors : list[(int)a[left]]) {
					
					if(divisors > m) {
						
						continue;
						
					}
					
					if(count[(int)divisors] == 1L) {
						
						--get;
						
					}
					
					count[(int)divisors]--;
					
				}
				
				++left;
				
			} else {
				
				++right;
				
				if(right >= n) {
					
					break;
					
				}
				
				for(long divisors : list[(int)a[right]]) {
					
					if(divisors > m) {
						
						continue;
						
					}
					
					if(count[(int)divisors] == 0L) {
						
						++get;
						
					}
					
					count[(int)divisors]++;
					
				}
				
			}
			
		}
		
		if(min_diff == Integer.MAX_VALUE) {
			
			System.out.println(-1);
			return;
			
		}
		
		System.out.println(min_diff);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		divisors();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static void divisors() {
		
		list = new List[100000 + 7];
		
		for(int i = 0; i < list.length; ++i) {
			
			list[i] = new ArrayList<>();
			
		}
		
		int N = list.length - 1;
		
		for(int i = 1; i <= N; ++i) {
			
			for(int j = 1; j * j <= i; ++j) {
				
				if(i % j == 0) {
					
					list[i].add((long)j);
					
					if(j * j != i) {
						
						list[i].add((long)(i / j));
						
					}
					
				}
				
			}
			
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