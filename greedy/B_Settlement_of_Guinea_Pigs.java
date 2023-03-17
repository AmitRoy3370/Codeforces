import java.util.Scanner;

public class B_Settlement_of_Guinea_Pigs {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		int one[] = new int[3];
		
		for(long i : a) {
			
			one[(int)i]++;
			
		}
		
		if(one[1] == n) {
			
			System.out.println(n);
			return;
			
		}
		
		if(one[2] == n) {
			
			System.out.println(0);
			return;
			
		}
		
		long unknown = 0L, known = 0L;
		
		long aviators = 0L;
		
		for(long i : a) {
			
			if(i == 1L) {
				
				unknown++;
				
			} else {
				
				known += unknown;
				unknown = 0L;
				
			}
			
			//System.out.print(known + " " + unknown + " ");
			
			long take = unknown + (known > 0L ? (long)Math.floor((double)known / 2.0) + 1L : 0L);
			
			//System.out.println(take + " " + aviators);
			
			aviators = Math.max(aviators, take);
			
		}
		
		System.out.println(aviators);
		
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