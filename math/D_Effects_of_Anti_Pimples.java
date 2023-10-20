import java.util.Scanner;

public class D_Effects_of_Anti_Pimples {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static long mod = 998_244_353L;
	
	static void solve() {
		
		long way = 0L;
		
		for(int black = 1; black <= n; ++black) {
			
			for(int green = black; green <= n; green += black) {
				
				a[black] = Math.max(a[black], a[green]);
				
			}
			
		}
		
		sort(a, 1, n);
		
		//print(a);
		
		for(int maximum_values_index = 1; maximum_values_index <= n; ++maximum_values_index) {
			
			way += a[maximum_values_index] * (pow(2L, (long)(maximum_values_index - 1), 1L));
			
			way %= mod;
			
		}
		
		System.out.println(way);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n + 1];
		
		for(int i = 1; i <= n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static long pow(long x, long y, long pow) {
		
		if(y == 0L) {
			
			return 1L;
			
		}
		
		pow = pow(x, y / 2L, pow) % mod;
		
		if(y % 2L == 1L) {
			
			return (pow * pow * x) % mod;
			
		} else {
			
			return (pow * pow) % mod;
			
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