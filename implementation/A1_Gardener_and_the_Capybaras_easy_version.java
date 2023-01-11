import java.util.Scanner;

public class A1_Gardener_and_the_Capybaras_easy_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static char a[];
	
	static void solve() {
		
		if(a[0] == 'a' && a[1] == 'b') {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(a[0]).append(" ");
			
			for(int i = 1; i < n - 1; ++i) {
				
				sb.append(a[i]);
				
			}
			
			sb.append(" ").append(a[n - 1]).append("\n");
			
			System.out.print(sb.toString());
			
		} else {
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(a[0]).append(" ").append(a[1]).append(" ");
			
			for(int i = 2; i < n; ++i) {
				
				sb.append(a[i]);
				
			}
			
			System.out.println(sb.toString());
			
		}
		
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