import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class B_250_Thousand_Tons_of_TNT {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		List<Integer> divisors = new ArrayList<>();
		
		divisors.add(1);
		//divisors.add(n);
		
		for(int i = 2; i * i <= n; ++i) {
			
			if(n % i == 0) {
				
				divisors.add(i);
				
				if(i != n / i) {
					
					divisors.add(n /i);
					
				}
			}
			
		}
		
		long maximum_difference = Long.MIN_VALUE;
		
		for(int divisible : divisors) {
			
			long lowest_track = Long.MAX_VALUE;
			long highest_track = Long.MIN_VALUE;
			
			for(int i = 0; i < n; i += divisible) {
				
				long sum = 0L;
				
				for(int j = i; j < i + divisible; ++j) {
					
					sum += a[j];
					
				}
				
				lowest_track = Math.min(lowest_track, sum);
				highest_track = Math.max(highest_track, sum);
				
			}
			
			long difference = highest_track - lowest_track;
			
			maximum_difference = Math.max(difference, maximum_difference);
			
		}
		
		System.out.println(maximum_difference);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
}
