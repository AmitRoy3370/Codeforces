import java.util.Scanner;
import java.util.Arrays;

public class B_Tokitsukaze_and_Mahjong {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String [] amit) {
		
		int ans[] = new int[3];
		
		for(int i = 0; i < 3; ++i) {
			
			String s = in.next();
			
			ans[i] = Integer.parseInt(s.charAt(0) + "") + Integer.parseInt((s.charAt(1) - 'a') + "") * 10;
			
		}
		
		Arrays.sort(ans);
		
		int first = ans[1] - ans[0], second = ans[2] - ans[1];
		
		int third = ans[2] - ans[0];
		
		//System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
		
		if(ans[0] == ans[1] && ans[1] == ans[2]) {
			
			System.out.print(0);
			return;
			
		}
		
		if(first == second && (second == 1 || first == 0)) {
			
			System.out.print(0);
			
		} else if(first <= 2 || second <= 2) {
			
			System.out.print(1);
			
		} else {
			
			System.out.print(2);
			
		}
		
	}
	
}