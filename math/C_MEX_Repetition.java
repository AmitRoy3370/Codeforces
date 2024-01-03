import java.util.Scanner;

public class C_MEX_Repetition {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	static long k;
	
	static int a[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve(int t) {
		
		StringBuilder sb = new StringBuilder();
		
		int final_ans[] = new int[n];
		
		int used[] = new int[n + 5];
		
		for(int i : a) {
			
			used[i]++;
			
		}
		
		for(int i = 0; i != n + 1; ++i) {
			
			if(used[i] == 0) {
				
				a[n] = i;
				
			}
			
		}
		
		var index = (int)(-k % (n + 1));
		
		if(0 > index) {
			
			index += n + 1;
			
		}
		
		for(int i = 0; i != n; ++i) {
			
			final_ans[i] = a[index]; 
			
			index++;
			index %= (n + 1);
			
		}
		
		for(int i : final_ans) {
			
			sb.append(i).append(" ");
		
		}
		
		ans.append(sb.toString().trim());
		
		if(t != testCases) {
			
			ans.append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve(t + 1);
			
		}
		
		System.out.print(ans.toString());
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		k = in.nextLong();
		
		a = new int[n + 1];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextInt();
			
		}
		
	}
	
}