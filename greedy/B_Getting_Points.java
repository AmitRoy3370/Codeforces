import java.util.Scanner;

public class B_Getting_Points {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long n, l, t, p;
	
	static void solve() {
		
		long l = 1L, r = n;
		
		while(r != l) {
			
			long working_days = (l + r) / 2L;
			
			if(score_can_gain(working_days) >= p) {
				
				r = working_days;
				
			} else {
				
				l = working_days + 1;
				
			}
			
		}
		
		long rest = n - l;
		
		System.out.println(rest);
		
	}
	
	private static long score_can_gain(long working_days) {
		
		long attend_lecture = working_days * l;
		
		long total_lab = (n + 6L) / 7L;
		
		long task_complete = 2L * working_days;
		
		long score = attend_lecture + Math.min(total_lab, task_complete) * t;
		
		return score;
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextLong();
		p = in.nextLong();
		l = in.nextLong();
		t = in.nextLong();
		
	}
	
}