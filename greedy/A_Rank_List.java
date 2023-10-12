import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A_Rank_List {
	
	static Scanner in = new Scanner(System.in);
	
	static int n, k;
	
	static participate p[];
	
	static void solve() {
		
		List<participate> list = new ArrayList<>();
		
		for(participate i : p) {
			
			list.add(i);
			
		}
		
		Collections.sort(list);
		
		int rank = 0;
		
		for(int i = 0; i < n; ++i) {
			
			if(list.get(i).strength == list.get(n - k).strength) {
				
				++rank;
				
			}
			
		}
		
		System.out.print(rank);
		
	}
	
	public static void main(String []amit) {
		
		input();
		solve();
		
	}
	
	static void input() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		p = new participate[n];
		
		for(int i = 0; i < n; ++i) {
			
			p[i] = new participate(in.nextInt(), in.nextInt(), i + 1);
			
		}
		
	}
	
	static class participate implements Comparable<participate> {
		
		int problem, time, team_id;
		
		long strength;
		
		public participate(int problem, int time, int team_id) {
			
			this.problem = problem;
			this.time = time;
			this.team_id = team_id;
			
			this.strength = this.problem * 50 - this.time;
			
		}
		
		public int compareTo(participate p) {
			
			if(this.strength > p.strength) {
				
				return 1;
				
			} else if(this.strength < p.strength) {
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}