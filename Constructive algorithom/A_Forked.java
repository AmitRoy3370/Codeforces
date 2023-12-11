import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class A_Forked  {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long a, b, xk, yk, xq, yq;
	
	static void solve() {
		
		long adder[] = new long[]{a, -a, b, -b};
		
		long other[] = new long[]{b, -b, b, -b, a, -a, a, -a};
		
		List<axis> king = new ArrayList<>();
		
		List<axis> queen = new ArrayList<>();
		
		int j_ = 0;
		
		for(int i = 0; i != adder.length; ++i) {
			
			axis axis_ = new axis(xk + adder[i], yk + other[j_++]);
			
			boolean can = true;
			
			for(axis j : king) {
				
				if(j.equal(axis_)) {
					
					can = false;
					break;
					
				}
				
			}
			
			if(can) {
				
				king.add(axis_);
				
			}
			
			axis_ = new axis(xk + adder[i], yk + other[j_++]);
			
			can = true;
			
			for(axis j : king) {
				
				if(j.equal(axis_)) {
					
					can = false;
					break;
					
				}
				
			}
			
			if(can) {
				
				king.add(axis_);
				
			}
			
		}
		
		j_ = 0;
		
		for(int i = 0; i != adder.length; ++i) {
			
			axis axis_ = new axis(xq + adder[i], yq + other[j_++]);
			
			boolean can = true;
			
			for(axis j : queen) {
				
				if(j.equal(axis_)) {
					
					can = false;
					break;
					
				}
				
			}
			
			if(can) {
				
				queen.add(axis_);
				
			}
			
			axis_ = new axis(xq + adder[i], yq + other[j_++]);
			
			can = true;
			
			for(axis j : queen) {
				
				if(j.equal(axis_)) {
					
					can = false;
					break;
					
				}
				
			}
			
			if(can) {
				
				queen.add(axis_);
				
			}
			
		}
		
		/*System.out.println("king");
		
		for(axis i : king) {
			
			System.out.println(i.toString());
			
		} 
		
		System.out.println("queen");
		
		for(axis i : queen) {
			
			System.out.println(i.toString());
			
		}*/
		
		boolean visited[] = new boolean[queen.size()];
		
		int fork = 0;
		
		for(int i = 0; i != king.size(); ++i) {
			
			for(int j = 0; j != queen.size(); ++j) {
				
				if(visited[j]) {
					
					continue;
					
				}
				
				if(king.get(i).equal(queen.get(j))) {
					
					visited[j] = true;
					++fork;
					
				}
				
			}
			
		}
		
		System.out.println(fork);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t != testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		a = in.nextLong();
		b = in.nextLong();
		
		xk = in.nextInt();
		yk = in.nextLong();
		
		xq = in.nextLong();
		yq = in.nextLong();
		
	}
	
	private static class axis {
		
		long x, y;
		
		public axis(long x, long y) {
			
			this.x = x;
			this.y = y;
			
		}
		
		private boolean equal(axis a) {
			
			return this.x == a.x && this.y == a.y;
			
		}
		
		public String toString() {
			
			return this.x + " " + this.y;
			
		}
		
	}
	
}