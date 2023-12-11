import java.util.Scanner;

public class D1_Set_To_Max_Easy_Version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		boolean yes = true;
		
		for(int i = 0; i != n; ++i) {
			
			if(a[i] == b[i]) {
				
				continue;
				
			}
			
			if(a[i] > b[i]) {
				
				yes = false;
				break;
				
			}
			
			// left partition
			
			boolean left_present = false;
			boolean right_present = false;
			
			for(int j = i - 1; j >= 0; --j) {
				
				if(a[j] == b[i]) {
					
					left_present = true;
					break;
					
				}
				
				if(b[i] > b[j]) {
					
					break;
					
				}
				
				if(a[j] > b[i]) {
					
					break;
					
				}
				
			}
			
			// right segment
			
			for(int j = i + 1; j != n; ++j) {
				
				if(a[j] == b[i]) {
					
					right_present = true;
					break; 
					
				}
				
				if(a[j] > b[i]) {
					
					break;
					
				}
				
				if(b[i] > b[j]) {
					
					break;
					
				}
				
			}
			
			if(!left_present && !right_present) {
				
				yes = false;
				break;
				
			}
			
		}
		
		if(yes) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
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
		b = new  long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = in.nextLong();
			
		}
		
	}
	
}