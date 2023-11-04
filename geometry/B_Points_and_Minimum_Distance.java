import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Points_and_Minimum_Distance {
	
	static int testCases, n;
	
	static Scanner in = new Scanner(System.in);
	
	static long a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		List<Long> list = new ArrayList<>();
		
		for(long i : a) {
			
			list.add(i);
			
		}
		
		Collections.sort(list);
		
		List<point> Points = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			long x = list.get(i);
			long y = list.get(2 * n - i - 1);
			
			Points.add(new point(x, y));
			
		}
		
		long sum = 0L;
		
		/*
		
		1	5	10	15
		
		
		*/
		
		for(int i = 1; i < Points.size(); ++i) {
			
			sum += Points.get(i).distance(Points.get(i - 1));
			
		}
		
		ans.append(sum).append("\n");
		
		for(point i : Points) {
			
			ans.append(i.toString()).append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[2 * n];
		
		for(int i = 0; i < 2 * n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	
	static class point {
		
		long x, y;
		
		public point(long x, long y) {
			
			this.x = x;
			this.y = y;
			
		}
		
		public long distance(point p) {
			
			return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
			
		}
		
		public String toString() {
			
			return this.x + " " + this.y;
			
		}
		
	}
	
}