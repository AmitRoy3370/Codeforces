import java.util.Scanner;

public class B_Applejack_and_Storages {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, testCases, N = 1000001, rectangle = 0, square = 0;
	
	static int a[], count[];
	
	static char operation;
	
	static int number;
	
	static void solve() {
		
		square -= count[number] / 4;
		rectangle -= count[number] / 2;
		
		if(operation == '+') {
			
			count[number]++;
			
		} else {
			
			count[number]--;
			
		}
		
		square += count[number] / 4;
		rectangle += count[number] / 2;
		
		if(square >= 1 && rectangle >= 4) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		a = new int[n];
		
		count = new int[N];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
			square -= count[a[i]] / 4;
			rectangle -= count[a[i]] / 2;
			
			count[a[i]]++;
			
			square += count[a[i]] / 4;
			rectangle += count[a[i]] / 2;
			
		}
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			operation = in.next().charAt(0);
			
			number = in.nextInt();
			
			if(operation == '+') {
				
				solve();
				
			} else {
				
				solve();
				
			}
			
		}
		
	}
	
}