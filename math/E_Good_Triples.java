import java.util.Scanner;

public class E_Good_Triples {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static char x[];
	
	static void solve() {
		
		long good_triples = 1L;
		
		for(char i : x) {
			
			good_triples *= way(i - '0');
			
		}
		
		System.out.println(good_triples);
		
	}
	
	private static long way(int digit) {
		
		++digit;
		
		long way = digit * (digit + 1);
		
		way /= 2L;
		
		return way;
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		x = in.next().toCharArray();
		
	}
	
}