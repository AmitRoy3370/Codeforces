import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A_A_Pivotal_Question {
	
	static Scanner in = new Scanner(System.in);
	
	static int n;
	
	static long a[];
	
	static List<Long> ans = new ArrayList<>();
	
	static void sort(long a[], int left, int right) {
		
		long max = a[0];
		
		boolean visit[] = new boolean[n];
		
		visit[0] = true;
		
		for(int i = 0; i != n; ++i) {
			
			if(a[i] > max) {
				
				max = a[i];
				visit[i] = true;
				
			}
			
		}
		
		if(visit[n - 1]) {
			
			ans.add(a[n - 1]);
			
		}
		
		long min = a[n - 1];
		
		for(int i = n - 1; i != -1; --i) {
			
			if(min > a[i]) {
				
				min = a[i];
				
				if(visit[i]) {
					
					ans.add(a[i]);
					
				}
				
			}
			
		}
		
		Collections.reverse(ans);
		
	}
	
	static void solve() {
		
		sort(a, 0, n - 1);
		
		System.out.print(ans.size() + " ");
		
		for(int i = 0; !(i >= Math.min(ans.size(), 100)); ++i) {
			
			System.out.print(ans.get(i) + " ");
			
		}
		
		System.out.println();
		
		//print(a);
		
	}
	
	public static void main(String [] amit) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static void print(long a[]) {
		
		for(long i : a) {
			
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		
	}
	
}
