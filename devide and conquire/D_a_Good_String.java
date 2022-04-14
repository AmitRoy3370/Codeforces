import java.util.Scanner;

public class D_a_Good_String {
	
	private static Scanner in = new Scanner(System.in);
	
	private static int testCases, n;
	
	private static char a[];
	
	private static int solve(String s,int left, int right, char c) {
		
		/*if(right <= left) {
			
			return 0;
			
		}*/
		
		char a[] = s.toCharArray();
		
		if((s.length()) == 1) {
			
			return ((a[0] == c) ? 0 : 1);
			
		}
		
		int mid = (s.length()) / 2, count1 = 0, count2 = 0;
		
		for(int i = 0; i < mid; ++i) {
			
			if(a[i] == c) {
				
				++count1;
				
			}
			
		}
		
		count1 = (mid) - count1;
		
		for(int i = mid; i < s.length(); ++i) {
			
			if(a[i] == c) {
				
				++count2;
				
			}
			
		}
		
		count2 = (mid) - count2;
		
		return Math.min(count1 + solve(s.substring(mid), mid + 1, right, (char)(c + 1)), count2 + solve(s.substring(0, mid) ,left, mid, (char)(c + 1)));
		
	}
	
	private static void solve() {
		
		System.out.println(solve(new String(a) ,0, n - 1, 'a'));
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}