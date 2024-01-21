import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class F_Greetings {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], b[];
	
	static void solve() {
		
		List<Ranges> ranges = new ArrayList<>();
		
		List<Long> endingPoint = new ArrayList<>();
		
		for(int i = 0; i < n; ++i) {
			
			ranges.add(new Ranges(a[i], b[i]));
			endingPoint.add(b[i]);
			
		}
		
		Collections.sort(ranges);
		
		Collections.sort(endingPoint);
		
		long greetings = 0L;
		
		for(Ranges range : ranges) {
			
			int canMeet = canMeet(endingPoint, range.endingPoint);
			
			greetings += canMeet;
			
			try {
				
				endingPoint.remove(canMeet);
				
			} catch(Exception e) {
				
			}
			
		}
		
		System.out.println(greetings);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new long[n];
		b = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			b[i] = in.nextLong();
			
 		}
		
	}
	
	private static class Ranges implements Comparable<Ranges> {
		
		long startingPoint, endingPoint;
		
		public Ranges(long startingPoint, long endingPoint) {
			
			this.startingPoint = startingPoint;
			this.endingPoint = endingPoint;
			
		}
		
		public int compareTo(Ranges r) {
			
			if(this.startingPoint > r.startingPoint) {
				
				return 1;
				
			} else if(this.startingPoint < r.startingPoint) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
	private static int canMeet(List<Long> endingPoint, long value) {
		
		if(endingPoint.get(0) > value) {
			
			return -1;
			
		}
		
		int left = 0, right = endingPoint.size();
		
		int index = -1;
		
		while(right > left) {
			
			int mid = (left + right) / 2;
			
			if(value > endingPoint.get(mid)) {
				
				left = mid + 1;
				index = mid;
				
			} else {
				
				right = mid;
				
			}
			
		}
		
		if(left < endingPoint.size() && endingPoint.get(left) >= value) {
			
			++left;
			++index;
			
		}
		
		return index;
		
	}
	
}