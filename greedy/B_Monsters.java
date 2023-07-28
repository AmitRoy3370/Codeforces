import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Monsters {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static long K;
	
	static void solve() {
		
		int final_ans[] = new int[n];
		
		List<pair> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			list.add(new pair(a[i] % K, i + 1));
			
		}
		
		int index = 0;
		
		for(pair i : list) {
			
			if(i.value == 0L) {
				
				final_ans[index++] = i.index;
				
			}
			
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(pair i : list) {
			
			if(i.value == 0L) {
				
				continue;
				
			}
			
			final_ans[index++] = i.index;
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : final_ans) {
			
			sb.append(i).append(" ");
			
		}
		
		System.out.println(sb.toString().trim());
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		K = in.nextLong();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static class pair implements Comparable<pair> {
		
		long value;
		int index;
		
		public pair(long value, int index) {
			
			this.value = value;
			this.index = index;
			
		}
		
		public int compareTo(pair p) {
			
			if(this.value > p.value) {
				
				return 1;
				
			} else if(this.value < p.value) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}