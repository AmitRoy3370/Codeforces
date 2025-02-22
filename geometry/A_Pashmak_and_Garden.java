import java.util.Scanner;

public class A_Pashmak_and_Garden {
	
	static Scanner in = new Scanner(System.in);
	
	static int x1, y1, x2, y2;
	
	static void solve() {
		
		if(x1 != x2 && y1 != y2 && Math.abs(x1 - x2) != Math.abs(y1 - y2)) {
			
			System.out.print("-1");
			return;
			
		} else if(x1 == x2) {
			
			System.out.print( (x1 + Math.abs(y1 - y2)) + " " + y1 + " " + (x2 + Math.abs(y1 - y2)) + " " + y2);
			
		} else if(y1 == y2) {
			
			System.out.print(x1 + " " + (Math.abs(x1 - x2) + y1) + " " + x2 + " " + (Math.abs(x1 - x2) + y2));
			
		} else {
			
			System.out.print(x1 + " " + y2 + " " + x2 + " " + y1);
			
		}
		
	}
	
	public static void main(String [] Priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		
	}
	
}