import java.util.Scanner;

public class C_Hard_Process {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static int a[];
	
	static StringBuilder answer = new StringBuilder();
	
	static void solve() {
		
		if(k == 0) {
			
			int max_len = 0;
			
			for(int i = 0; i < n; ++i) {
				
				int temp_length = 0;
				
				while(i < n && a[i] == 1) {
					
					++temp_length;
					
					++i;
					
				}
				
				max_len = Math.max(max_len, temp_length);
				
			}
			
			answer.append(max_len).append("\n");
			
			for(int i : a) {
				
				answer.append(i).append(" ");
				
			}
			
			return;
			
		}
		
		int max_len = 0, start = 0, end = -1;
		
		int zero = 0, j = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(a[i] == 0) {
				
				++zero;
				
			}
			
			if((i - j + 1) >= max_len && zero <= k) {
				
				max_len = (i - j + 1);
				
				start = j;
				end = i;
				
			} else {
				
				if(a[j] == 0) {
					
					--zero;
					
				}
				
				++j;
				
			}
			
		}
		
		answer.append(max_len).append("\n");
		
		if(end == -1) {
			
			for(int i : a) {
				
				answer.append(i).append(" ");
				
			}
			
			return;
			
		}
		
		for(int i = start; i <= end; ++i) {
			
			a[i] = 1;
			
		}
		
		for(int i : a) {
			
			answer.append(i).append(" ");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
		solve();
		
		System.out.print(answer.toString().trim());
		
	}
	
}