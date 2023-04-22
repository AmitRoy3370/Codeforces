import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Search_in_Parallel {
	
	static int testCases, n;
	
	static long s1, s2;
	
	static long r[];
	
	static Scanner in = new Scanner(System.in);
	
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		request_color rc[] = new request_color[n];
		
		List<request_color> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			rc[i] = new request_color(r[i], i + 1);
			
			list.add(rc[i]);
			
		}
		
		Collections.sort(list);
		
		int index_a = 0, index_b = 0;
		
		List<Long> a = new ArrayList<>();;
		
		List<Long> b = new ArrayList<>();
		
		for(request_color i : list) {
			
			request_color element = i;
			
			long f1 = (a.size() + 1) * s1;
			
			long f2 = (b.size() + 1) * s2;
			
			if(f1 < f2) {
				
				a.add((long)element.color);
				
			} else {
				
				b.add((long)element.color);
				
			}
			
		}
		
		StringBuilder s = new StringBuilder();
		
		s.append(a.size()).append(" ");
		
		for(long i : a) {
			
			s.append(i).append(" ");
			
		}
		
		sb.append(s.toString().trim()).append("\n");
		
		s = new StringBuilder();
		
		s.append(b.size()).append(" ");
		
		for(long i : b) {
			
			s.append(i).append(" ");
			
		}
		
		sb.append(s.toString().trim()).append("\n");
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			n = in.nextInt();
			
			s1 = in.nextLong();
			
			s2 = in.nextLong();
			
			r = new long[n];
			
			for(int i = 0; i < n; ++i) {
				
				r[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	static class request_color implements Comparable<request_color> {
		
		long request_number;
		
		int color;
		
		public request_color(long request_number, int color) {
			
			this.color = color;
			this.request_number = request_number;
			
		}
		
		public int compareTo(request_color a) {
			
			if(a.request_number > this.request_number) {
				
				return 1;
				
			} else if(a.request_number < this.request_number) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
		public String toString() {
			
			return request_number + " " + color;
			
		}
		
	}
	
}