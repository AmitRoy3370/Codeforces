import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class B_Erase_First_or_Second_Letter {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char x[];
	
	static void solve() {
		
		Set<Character> set = new HashSet<>();
		
		long variation = 0L;
		
		for(char i : x) {
			
			set.add(i);
			
			variation += set.size();
			
		}
		
		System.out.println(variation);
		
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
		
		x = in.next().toCharArray();
		
	}
	
}