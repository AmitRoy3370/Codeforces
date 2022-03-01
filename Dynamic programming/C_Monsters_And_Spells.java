import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Monsters_And_Spells{
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long h[], k[];
	
	static void solve(){
		
		List<Pair> list = new ArrayList<>();
		
		for(int i = 0; i < n; ++i){
			
			list.add(new Pair(k[i] - h[i], k[i]) );
			
		}
		
		Collections.sort(list);
		
		long left_corner = -1, right_corner = -1;
		
		long ans = 0;
		
		for(Pair i: list){
			
			if(i.difference >= right_corner ){
				
				ans += ((right_corner -left_corner) * (right_corner - left_corner + 1)) / 2;
				
				left_corner =  i.difference;
				right_corner = i.appearing_time;
				
			}else{
				
				right_corner = Math.max(right_corner, i.appearing_time );
				
			}
			
		}
		
		ans += ((right_corner - left_corner) * (right_corner - left_corner + 1)) / 2;
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] amit){
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t){
			
			n = in.nextInt();
			
			h = new long[n];
			k = new long[n];
			
			for(int i = 0; i < n; ++i){
				
				k[i] = in.nextLong();
				
			}
			
			for(int i = 0; i < n; ++i){
				
				h[i] = in.nextLong();
				
			}
			
			solve();
			
		}
		
	}
	
	static class Pair implements Comparable<Pair>{
		
		long difference, appearing_time;
		
		public Pair(long difference, long appearing_time){
			
			this.difference = difference;
			this.appearing_time = appearing_time;
			
		}
		
		public int compareTo(Pair pair){
			
			if(this.difference > pair.difference ){
				
				return 1;
				
			}else if(this.difference < pair.difference ){
				
				return -1;
				
			}
			
			return 0;
			
		}
		
	}
	
}

/*

1
2
1 2
1 2

*/