import java.util.Scanner;

public class A_Hall_of_Fame {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		boolean equal = true;
		
		for(int i = 0; i < n - 1; ++i) {
			
			if(a[i] != a[i + 1]) {
				
				equal = false;
				break;
				
			}
			
		}
		
		if(equal) {
			
			System.out.println(-1);
			return;
			
		}
		
		int last_l = -1, first_r = -1;
		
		for(int i = 0, j = n - 1; i < n && j >= 0; ++i, --j) {
			
			if(a[i] == 'L') {
				
				last_l = i;
				
			} 
			
			if(a[j] == 'R') {
				
				first_r = j;
				
			}
			
		}
		
		int left = last_l;
		
		int right = n - 1 - first_r;
		
		//System.out.println(left + " " + first_r);
		
		if(left + right == n) {
			
			System.out.println(0);
			
		} else if(left + right + 2 >= n) {
			
			System.out.println(first_r);
			
		}
		
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