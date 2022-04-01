import java.util.Scanner;

public class B_Vlad_and_Candies {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(n == 1 && a[0] == 1) {
			
			System.out.println("YES");
			
			return;
			
		}
		
		if(n == 1 && a[0] > 1) {
			
			System.out.println("NO");
			
			return;
			
		}
		
		int max_index = 0, max_index1 = 0;
		
		long max = a[0];
		
		boolean visit[] = new boolean[n];
		
		for(int i = 0; i < n; ++i) {
			
			if(max < a[i]) {
				
				max = a[i];
				max_index = i;
				
			}
			
		}
		
		visit[max_index] = true;
		
		long maximum = max;
		
		max = Long.MIN_VALUE;
		
		for(int i = max_index; i < n - 1; ++i) {
			
			long temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
			
		}
		
		/*for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();*/
		
		--n;
		
		for(int i = 0; i < n; ++i) {
			
			if(max <= a[i]) {
				
				max = a[i];
				max_index1 = i;
				
			}
			
		}
		
		//System.out.println("max_index1 : " + max_index1);
		
		if(maximum - max <= 1 ) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] amit) {
		
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
	
}

/*

1
4
10 4 8 4

*/

/*

1
5
1 6 2 4 3

*/