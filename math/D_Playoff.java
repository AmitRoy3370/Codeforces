import java.util.Scanner;

public class D_Playoff {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		StringBuilder winners = new StringBuilder();
		
		long start = 1L, end = pow(2L, (long)n);
		
		int one = 0, zero = 0;
		
		for(int i = 0; i != n; ++i) {
			
			if(x[i] == '0') {
				
				++zero;
				
				end -= pow(2L, (long)(zero - 1));
				
			} else {
				
				++one;
				
				start += pow(2L, (long)(one - 1));
				
			}
			
		}
		
		//System.out.println(start + " " + end);
		
		while(start != end + 1) {
			
			winners.append(start).append(" ");
			
			++start;
			
		}
		
		ans.append(winners);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = 1;
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString().trim());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		x = in.next().toCharArray();
		
	}
	
	private static long pow(long value, long power) {
		
		long powValue = 1L;
		
		while(power > 0L) {
			
			if(power % 2L == 1) {
				
				powValue *= value;
				
			} 
			
			value *= value;
				
			power /= 2L;
			
		}
		
		return powValue;
		
	}
	
}