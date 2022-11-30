import java.util.Scanner;

public class B_Broken_Keyboard {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		boolean possible = true;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0, time = 1; i < n; ++i, ++time) {
			
			if(time % 2 == 1) {
				
				sb.append(a[i]);
				
			} else {
				
				sb.append(a[i]).append(a[i]);
				++i;
				
			}
			
		}
		
		//System.out.println(sb.toString());
		
		if(sb.toString().equals(new String(a))) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			a = in.next().toCharArray();
			
			solve();
			
		}
		
	}
	
}