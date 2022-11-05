import java.util.Scanner;

public class Codeforces_Round_832_Div_2 {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void A_Two_Groups() {
		
		long sum = 0L;
		
		for(long i : a) {
			
			sum += i;
			
		}
		
		System.out.println(Math.abs(sum));
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				a[i] = in.nextLong();
				
			}
			
			A_Two_Groups();
			
		}
		
	}
	
}