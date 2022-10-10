import java.util.Scanner;

public class C_Min_Max_Array_Transformation {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		int max = n - 1;
		
		long d_max[] = new long[n];
		long d_min[] = new long[n];
		
		for(int i = n - 1; i >= 0; --i) {
			
			long value = a[i];
			
			int point = binary_search(value, b);
			
			if(point == i) {
				
				d_min[i] = b[i] - value;
				d_max[i] = b[max] - value;
				
				max = i - 1;
				
			} else {
				
				d_max[i] = b[max] - value;
				d_min[i] = b[point] - value;
				
			}
			
		}
		
		print(d_min);
		print(d_max);
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			b = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i) {
				
				b[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static int binary_search(long value, long a[]) {
		
		int left = 0, right = a.length;
		
		while(right > left) {
			
			int mid = (left + right) / 2;
			
			if(a[mid] < value) {
				
				left = mid + 1;
				
			} else {
				
				right = mid;
				
			}
			
		}
		
		return left;
		
	}
	
	static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}