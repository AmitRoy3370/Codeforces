import java.util.Scanner;

public class B_Lecture_Sleep {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static long a[];
	
	static int t[];
	
	static void solve() {
		
		long activePrefix[] = new long[n];
		long sleepingPrefix[] = new long[n];
		
		activePrefix[0] = (t[0] == 0 ? 0L : a[0]);
		sleepingPrefix[0] = (t[0] == 0 ? a[0] : 0L);
		
		for(int i = 1; i < n; ++i) {
			
			if(t[i] == 1) {
				
				activePrefix[i] = activePrefix[i - 1] + a[i];
				sleepingPrefix[i] = sleepingPrefix[i - 1];
				
			} else {
				
				sleepingPrefix[i] = sleepingPrefix[i - 1] + a[i];
				activePrefix[i] = activePrefix[i - 1];
				
			}
			
		}
		
		long learned = Long.MIN_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			if(t[i] == 0) {
				
				int start = i, end = Math.min(i + k - 1, n - 1);
				
				long leftActiveSum = activePrefix[Math.max(start - 1, 0)];
				long rightActiveSum = (activePrefix[n - 1] - activePrefix[end]);
				long midActiveSum = (start - 1) >= 0 ? (activePrefix[end] - activePrefix[start - 1]) : activePrefix[end];
				
				long wakeUpSum = start - 1 >= 0 ? (sleepingPrefix[end] - sleepingPrefix[start - 1]) : sleepingPrefix[end];
				
				long learn = leftActiveSum + rightActiveSum + midActiveSum + wakeUpSum;
				
				learned = Math.max(learned, learn);
				
			}
			
		}
		
		if(learned == Long.MIN_VALUE) {
			
			learned = activePrefix[n - 1];
			
		}
		
		System.out.print(learned);
		
	}
	
	public static void main(String [] Priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		t = new int[n];
		
		for(int i = 0; i < n; ++i) {
			
			t[i] = in.nextInt();
			
		}
		
	}
	
}