import java.util.Scanner;

public class C_Another_Array_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	/*
	
	eg1:
	
	1	1	1
	
	res : = 1 + 1 + 1 = 3
	
	eg2:
	
	9	1
	
	-> 8	8 
	res : 8 + 8 = 16
	
	4	9	5
	
	-> 4 + 9 + 5 = 18
	
	eg3:
	
	6	19	3	4	4	2	6	7	8
	
	6	19	5	5	5	5	5	5	5
	
	6	19	0	0	0	0	0	0	0
	
	6	19	19	19	19	19	19	19	19
	
	13	13	19	19	19	19	19	19	19
	
	0	0	19	19	19	19	19	19	19
	
	19	19	19	19	19	19	19	19	19
	
	res := 19 * 9 = 171
	
	eg4:
	
	1	3	1
	
	2	2	1
	
	2	1	1
	
	2	0	0
	
	2	2	2
	
	res := 2 + 2 + 2 = 6
	
	*/
	
	static void solve() {
		
		if(n == 2) {
			
			long res = 2 * Math.abs(a[0] - a[1]);
			
			System.out.println(Math.max(res, a[0] + a[1]));
			
		} else if(n == 3) {
			
			if(Math.max(a[0], Math.max(a[1], a[2])) == a[n - 1]) {
				
				long res = 3 * a[n - 1];
				
				System.out.println(res);
				return;
				
			} else if(Math.max(a[0], Math.max(a[1], a[2])) == a[0]) {
				
				long res = 3 * a[0];
				
				System.out.println(res);
				
				return;
				
			}
			
			long natural_sum = a[0] + a[1] + a[2];
			
			long rev_first = n * Math.abs(a[0] - a[1]);
			
			long rev_second = n * Math.abs(a[1] - a[2]);
			
			long whole = Math.max(3L * a[0], 3L * a[2]);
			
			long res = Math.max(Math.max(natural_sum, rev_first), Math.max(rev_second, whole));
			
			System.out.println(res);
			
		} else {
			
			long max = a[0];
			
			for(long i : a) {
				
				max = Math.max(i, max);
				
			}
			
			long res = max * n;
			
			System.out.println(res);
			
		}
		
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
	
}