import java.util.Scanner;

public class G1_Dances_Easy_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, m;
	
	static long a[], b[];
	
	static void solve() {
		
		int operations = 0;
		
		int index_a = 0, index_b = 0;
		
		sort(a, 0, n - 1);
		sort(b, 0, n - 1);
		
		while(index_b < n) {
			
			if(a[index_a] >= b[index_b]) {
				
				++operations;
				
			} else {
				
				++index_a;
				
			}
			
			++index_b;
			
		}
		
		System.out.println(operations);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new long[n];
		b = new long[n];
		
		a[0] = 1L;
		
		for(int i = 1; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
	private static void sort(long a[], int l, int r) {
		
		if(r <= l) {
			
			return;
			
		}
		
		int mid = (l + r) / 2;
		
		sort(a, l, mid);
		sort(a, mid + 1, r);
		merge(a, l, r, mid);
		
	}
	
	private static void merge(long a[], int l, int r, int mid) {
		
		int n1 = (mid - l + 1);
		int n2 = (r - mid);
		
		long L[] = new long[n1];
		long R[] = new long[n2];
		
		for(int i = 0; i < n1; ++i) {
			
			L[i] = a[l + i];
			
		}
		
		for(int i = 0; i < n2; ++i) {
			
			R[i] = a[mid + i + 1];
			
		}
		
		int i = 0, j = 0, index = l;
		
		while(i < n1 && j < n2) {
			
			if(L[i] <= R[j]) {
				
				a[index++] = L[i++];
				
			} else {
				
				a[index++] = R[j++];
				
			}
			
		}
		
		while(i < n1) {
			
			a[index] = L[i];
			++i;
			++index;
			
		}
		
		while(j < n2) {
			
			a[index] = R[j];
			index++;
			j++;
			
		}
		
	}
	
}