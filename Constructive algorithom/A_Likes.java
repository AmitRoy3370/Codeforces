import java.util.Scanner;

public class A_Likes {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int positive = 0, negative = 0;
		
		for(long i : a) {
			
			if(i >= 0L) {
				
				++positive;
				
			} else {
				
				++negative;
				
			}
			
		}
		
		int likes = 0;
		
		for(int i = 0; i < positive; ++i) {
			
			System.out.print(++likes + " ");
			
		}
		
		for(int i = 0; i < negative; ++i) {
			
			System.out.print(--likes + " ");
			
		}
		
		System.out.println();
		
		for(int i = 0; i < negative; ++i) {
			
			System.out.print(1 + " " + 0 + " ");
			
		}
		
		positive -= negative;
		
		for(int i = 0; i < positive; ++i) {
			
			System.out.print((i + 1) + " ");
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
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
		
		for(int i = 0; i < n1; ++i) {
			
			L[i] = a[left + i];
			
		}
		
		for(int i = 0; i < n2; ++i) {
			
			R[i] = a[mid + 1 + i];
			
		}
		
		int i = 0, j = 0, k = left;
		
		while(i < n1 && j < n2) {
			
			if(L[i] < R[j]) {
				
				a[k++] = L[i++];
				
			} else {
				
				a[k++] = R[j++];
				
			}
			
		}
		
		while(i < n1) {
			
			a[k] = L[i];
			
			++i;
			++k;
			
		}
		
		while(j < n2) {
			
			a[k] = R[j];
			++k;
			++j;
			
		}
		
	}
	
	static void sort(long a[], int left, int right) {
		
		if(left >= right) {
			
			return;
			
		}
		
		int mid = (left + right) / 2;
		
		sort(a, left, mid);
		sort(a, mid + 1, right);
		merge(a, left, right, mid);
		
	}
	
}