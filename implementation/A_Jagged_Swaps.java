import java.util.Scanner;
import java.util.Arrays;

public class A_Jagged_Swaps {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		long b[] = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			b[i] = a[i];
			
		}
		
		Arrays.sort(b);
		
		boolean visit[] = new boolean[n];
		
		for(int i = n - 1; i >= 0; --i) {
			
			if(a[i] == b[i]) {
				
				continue;
				
			}
			
			int finding_index = -1;
			
			for(int j = 0; j < n; ++j) {
				
				if(visit[j]) {
					
					continue;
					
				}
				
				if(b[i] == a[j]) {
					
					finding_index = j;
					break;
					
				}
				
			}
			
			if(finding_index == -1) {
				
				System.out.println("NO");
				return;
				
			}
			
			if(finding_index > i) {
				
				System.out.println("NO");
				return;
				
			} else {
				
				int j = finding_index;
				
				while(j < n && finding_index != i) {
					
					if(j + 1 < n && j - 1 >= 0) {
						
						if(a[j] > a[j + 1] && a[j] > a[j - 1]) {
							
							swap(a, j, j + 1);
							
						} else {
							
						}
						
					}
					
					++j;
					
				}
				
			}
			
			visit[i] = true;
			
		}
		
		if(isSorted(a)) {
			
			System.out.println("YES");
			
		} else {
			
			System.out.println("NO");
			
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
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	private static void swap(long a[], int i, int j) {
		
		long temp  = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	private static boolean isSorted(long a[]) {
		
		for(int i = 1; i < n; ++i) {
			
			if(a[i - 1] > a[i]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
}