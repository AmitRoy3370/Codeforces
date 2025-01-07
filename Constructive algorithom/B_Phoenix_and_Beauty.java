import java.util.Scanner;

public class B_Phoenix_and_Beauty {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k;
	
	static int a[];
	
	static void solve() {
		
		int count[] = new int[n + 1];
		
		for(int i : a) {
			
			count[i]++;
			
		}
		
		int unique = 0;
		
		String numbers = "";
		
		for(int i = 1; i <= n; ++i) {
			
			if(count[i] > 0) {
				
				numbers += i + " ";
				
				++unique;
				
			}
			
		}
		
		if(unique > k) {
			
			System.out.println("-1");
			
		} else {
			
			System.out.println(n * k);
			
			for(int i = 0; i < n; ++i) {
				
				System.out.print(numbers);
				
				for(int j = 0; j < k - unique; ++j) {
					
					System.out.print("1 ");
					
				}
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}