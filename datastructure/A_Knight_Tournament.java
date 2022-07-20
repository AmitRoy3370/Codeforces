import java.util.Scanner;
import java.util.TreeSet;

public class A_Knight_Tournament {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, m;
	
	static int L[], R[], X[];
	
	/*
	
	    8 4
	    3 5 4 -> (3, 4), (4, 5) here 3 and 5 are defeated by the 4
	    3 7 6 -> (3, 4), (3, 6), (3, 7) here 4 and 7 is defeated by the 6
	    2 8 8 -> (2, 8) here is 8 is defeated by the 2
	    1 8 1 -> (1, 8) here 8 is defeated by the 1 
		
		so 1 is winner of the tournament, no one 
		can defeated it
		
		-> 1 2 3 4 5 6 7 8
		-> 1 2   4   6 7 8
		-> 1 2           8
		-> 1             8
		-> 1
	
	*/
	
	static void solve() {
		
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i = 0; i < n; ++i) {
			
			set.add(i);
			
		}
		
		int index = 0;
		
		int ans[] = new int[n];
		
		for(int i = 0; i < m; ++i) {
			
			--L[i];
			--R[i];
			
			Integer value = set.ceiling(L[i]);
			
			while(value != null && value <= R[i]) {
				
				set.remove(value);
				
				ans[value] = X[i];
				
				value = set.ceiling(L[i]);
				
			}
			
			ans[X[i] - 1] = 0;
			set.add(X[i] - 1);
			
		}
		
		for(int i : ans) {
			
			System.out.print(i + " ");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		m = in.nextInt();
		
		L = new int[m];
		R = new int[m];
		X = new int[m];
		
		for(int i = 0; i < m; ++i) {
			
			L[i] = in.nextInt();
			R[i] = in.nextInt();
			X[i] = in.nextInt();
			
		}
		
		solve();
		
	}
	
}