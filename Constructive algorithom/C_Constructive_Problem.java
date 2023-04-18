import java.util.Scanner;

public class C_Constructive_Problem {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long mex = Mex(a);
		
		if(mex == n) {
			
			System.out.println("NO");
			return;
			
		}
		
		if(contains(a, mex + 1)) {
			
			int first_mex = -1, last_mex = -1;
			
			for(int i = 0; i < n; ++i) {
				
				if(a[i] == mex + 1) {
					
					if(first_mex == -1) {
						
						first_mex = i;
						
					} else {
						
						last_mex = i;
						
					}
					
				}
				
			}
			
			if(last_mex == -1) {
				
				last_mex = first_mex;
				
			}
			
			for(int i = first_mex; i <= last_mex; ++i) {
				
				a[i] = mex;
				
			}
			
			if(Mex(a) == mex + 1) {
				
				System.out.println("YES");
				
			} else {
				
				System.out.println("NO");
				
			}
			
		} else {
			
			System.out.println("YES");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static long Mex(long a[]) {
		
		int n = a.length;
		
		int b[] = new int[n];
		
		for(long i : a) {
			
			if(i < n) {
				
				b[(int)i]++;
				
			}
			
		}
		
		long mex = 0L;
		
		while(mex < n && b[(int)mex] > 0L) {
			
			++mex;
			
		}
		
		return mex;
		
	} 
	
	static boolean contains(long a[], long element) {
		
		boolean find = false;
		
		for(long i : a) {
			
			if(i == element) {
				
				return true;
				
			}
			
		}
		
		return find;
		
	}
	
}