import java.util.Scanner;

public class A_Halloumi_Boxes {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static long a[];
	
	static void solve() {
		
		if(isSorted(a) || k > 1) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
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
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static boolean isSorted(long a[]) {
		
		for(int i = 1; i < a.length; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	private static void swap(long a[], int i, int j) {
		
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	private static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}