import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class E_Correct_Placement {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases,n;
	
	static long w[], h[];
	
	static StringBuilder ans = new StringBuilder();
	
	static void solve() {
		
		Man man[] = new Man[n];
		
		for(int i = 0; i < n; ++i) {
			
			man[i] = new Man(Math.min(w[i], h[i]), Math.max(w[i], h[i]));
			
			man[i].position = i + 1;
			
		}
		
		List<Man> list = new ArrayList<>();
		
		for(Man i : man) {
			
			list.add(i);
			
		}
		
		Collections.sort(list);
		
		int index = 0;
		
		for(Man i : list) {
			
			man[index++] = i;
			
		}
		
		/*System.out.println("----------------");
		
		for(Man i : man) {
			
			System.out.print(i.toString());
			
		}
		
		System.out.println("------------------");*/
		
		int indexes[] = new int[n];
		
		int min_area_man = man[0].position;
		
		long min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; ++i) {
			
			if(man[i].height > min) {
				
				indexes[man[i].position - 1] = min_area_man;
				
			} else {
				
				indexes[man[i].position - 1] = -1;
				
			}
			
			if(min > man[i].height) {
				
				min = man[i].height;
				min_area_man = man[i].position;
				
			}
			
		}
		
		for(int i : indexes) {
			
			ans.append(i).append(" ");
			
		}
		
		ans.append("\n");
		
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
		
		w = new long[n];
		h = new long[n];
		
		for(int i = 0; i < n; ++i) {
			
			h[i] = in.nextLong();
			w[i] = in.nextLong();
			
		}
		
	}
	
	static class Man implements Comparable<Man> {
		
		long width, height;
		
		int position;
		
		public Man(long width, long height) {
			
			this.width = width;
			this.height = height;
			
		}
		
		public int compareTo(Man man) {
			
			if(this.width > man.width) {
				
				return 1;
				
			} else if(this.width < man.width) {
				
				return -1;
				
			} else if(this.width == man.width) {
				
				if(this.height > man.height) {
					
					return -1;
					
				} else if(this.height < man.height) {
					
					return 1;
					
				}
				
			}
			
			return 0;
			
		}
		
		public String toString() {
			
			return width + " " + height + " " + position + "\n";
			
		}
		
	}
	
}