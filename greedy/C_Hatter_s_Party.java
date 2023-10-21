import java.util.Scanner;

public class C_Hatter_s_Party {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static long a[];
	
	static void solve() {
		
		long sum = 0L;
		
		sort(a, 0, n);
		
		if(k == 1) {
			
			for(long i : a) {
				
				sum += i;
				
			}
			
			System.out.println(sum);
			return;
			
		}
		
		if(n == k) {
			
			System.out.println(a[n]);
			return;
			
		}
		
		int i = 1, j = n;
		
		while(i < j) {
			
			i += k - 1;
			
			sum += a[j];
			--j;
			
			if(j - i + 1 < k) {
				
				break;
				
			}
			
		}
		
		System.out.println(sum);
		
	}
	
	public static void main(String []priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
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
	
	private static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}
