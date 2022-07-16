import java.util.Scanner;

public class C_Mark_and_His_Unfinished_Essay {
	
    static Scanner in = new Scanner(System.in);

    static StringBuilder ans = new StringBuilder();

    static int testCases, n, c, q;
	
	static String S;
	
	static long L[], R[];
	
	static void solve() {
		
		char s[] = S.toCharArray();
		
		long size[] = new long[c + 1];
		
		long difference[] = new long[c + 1];
		
		L[0] = 0L;
		R[0] = (long)n;
		
		for(int i = 1; i <= c; ++i) {
			
			long left = L[i] - 1L, right = R[i] - 1L;
			
			L[i] = R[i - 1];
			R[i] = L[i] + (right - left + 1);
			difference[i] = L[i] - left;
			
		}
		
		while(q-- > 0) {
			
			long x = in.nextLong() - 1L;
			
			for(int j = c; j >= 1; --j) {
				
			   if(L[j] > x) continue;
			   else x -= difference[j];
			   
			}
			
			ans.append(s[(int)x]).append("\n");
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		int t = testCases;
		
		while(t-- > 0) {
			
			n = in.nextInt();
			
			c = in.nextInt();
			
			q = in.nextInt();
			
			//in.nextLine();
			
			S = in.next();
			
			L = new long[c + 1];
			R = new long[c + 1];
			
			for(int i = 1; i <= c; ++i) {
				
				long a = in.nextLong(), b = in.nextLong();
				
				L[i] = a;
				R[i] = b;
				
			}
			
			solve();
			
		}
		
		System.out.print(ans.toString());
		//out.flush();
		
	}
	
}