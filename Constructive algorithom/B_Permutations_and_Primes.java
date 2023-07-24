import java.util.Scanner;

public class B_Permutations_and_Primes {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		long permutation[] = new long[n];
		
		if(n <= 2) {
			
			for(int i = 0; i < n; ++i) {
				
				permutation[i] = i + 1;
				
			}
			
			
		    StringBuilder sb = new StringBuilder(); 
		
		    for(long i : permutation) {
			
			  sb.append(i).append(" ");
			
		    }
		
		    ans.append(sb.toString().trim()).append("\n");
			return;
		
		}
		
		permutation[0] = 3L;
		
		permutation[n / 2] = 1L;
		
		permutation[n - 1] = 2L;
		
		long element = 4L;
		
		for(int i = 0; i < n; ++i) {
			
			if(permutation[i] != 0L) {
				
				continue;
				
			}
			
			permutation[i] = element++;
			
		}
		
		StringBuilder sb = new StringBuilder(); 
		
		for(long i : permutation) {
			
			sb.append(i).append(" ");
			
		}
		
		ans.append(sb.toString().trim()).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString().trim());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
	}
	
}