import java.util.Scanner;

public class C1_Exam_in_BerSU_easy_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static int a[];
	
	static void solve() {
		
		int i = 0;
		
		long sum = 0;
		
		for(i = 0; i < n; ++i) {
			
			sum += a[i];
			
			if(sum > m ) {
				
				sum -= a[i];
				
				break;
				
			}
			
			System.out.print(0 + " ");
			
		}
		
		//System.out.println("i : " + i);
		
		for(int index = i; index < n; ++index) {
			
			sum += a[index];
			
			long arr[] = new long[index + 1];
			
			int j = 0;
			
			for(int k = 0; k < index; ++k, ++j) {
				
			  try {	
				
				arr[j] = a[k];
				
			  } catch(ArrayIndexOutOfBoundsException e) {
                 
                    break;				 
					
			  }
				
			}
			
			sort(arr, 0, arr.length - 1);
			
			/*for(long i1 : arr) {
				
				System.out.print(i1 + " ");
				
			}
			
			System.out.println();*/
			
			long copySum = sum;
			
			j = 0;
			
			while(j < arr.length && copySum > m) {
				
				copySum -= arr[j];
				
				++j;
				
			}
			
			System.out.print(j + " ");
			
			//sum += a[index];
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
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