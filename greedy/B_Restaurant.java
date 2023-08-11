import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Restaurant {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long L[], R[];
	
	static void solve() {
		
		List<ScheduledFuture> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			list.add(new ScheduledFuture(L[i], R[i]));
			
		}
		
		Collections.sort(list);
		
		/*for(ScheduledFuture i : list) {
			
			System.out.println(i.toString());
			
		}*/
		
		int accepted = 0;
		
		long last_end = -1;
		
		for(int i = 0; i < n; ++i) {
			
			if(list.get(i).start > last_end) {
				
				++accepted;
				
				last_end = list.get(i).end;
				
			}
			
		}
		
		System.out.println(accepted);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		L = new long[n];
		
		R = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			L[i] = in.nextLong();
			R[i] = in.nextLong();
			
		}
		
	}
	
	static class ScheduledFuture implements Comparable<ScheduledFuture> {
		
		long start, end;
		
		public ScheduledFuture(long start, long end) {
			
			this.start = start;
			this.end = end;
			
		}
		
		public int compareTo(ScheduledFuture that) {
			
			if(this.end > that.end) {
				
				return 1;
				
			} else if(this.end < that.end) {
				
				return -1;
				
			}
			
			if(this.start > that.start) {
				
				return 1;
				
			} else if(this.start < that.start) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
		public String toString() {
			
			return this.start + " " + this.end;
			
		}
		
	}
	
}