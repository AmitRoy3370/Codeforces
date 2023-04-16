import java.util.Scanner;

public class B_JoJo_s_Incredible_Adventures {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		int max_one = 0, one = 0;
		
		a = (new String(a) + new String(a)).toCharArray();
		
		int len = a.length, index = 0;
		
		for(char i : a) {
			
			if(index >= len - 1) {
				
				break;
				
			}
			
			if(i - '0' == 1) {
				
				++one;
				
			} else {
				
				max_one = Math.max(max_one, one);
				
				one = 0;
				
			}
			
			++index;
			
		}
		
		max_one = Math.max(max_one, one);
		
		long Len = (max_one + 1) / 2;
		long width = (max_one - Len + 1);
		
		long area = Len * width;
		
		System.out.println(area);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.next().toCharArray();
			
			n = a.length;
			
			solve();
			
		}
		
	}
	
}