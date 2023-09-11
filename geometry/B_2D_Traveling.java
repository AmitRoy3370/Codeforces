import java.util.Scanner;

public class B_2D_Traveling {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n, k, a, b;
	
	static long x[], y[];
	
	static void solve() {
		
		City city[] = new City[n];
		
		for(int i = 0; i < n; ++i) {
			
			city[i] = new City(x[i], y[i]);
			
		}
		
		for(int i = 0; i < k; ++i) {
			
			city[i].major = true;
			
		}
		
		City source = city[a - 1];
		
		City distination = city[b - 1];
		
		long min_distance_from_source_to_any_one_major_cities = Long.MAX_VALUE;
		
		for(int i = 0; i < k; ++i) {
			
			long distance = city[i].distance(source);
			
			min_distance_from_source_to_any_one_major_cities = Math.min(distance, min_distance_from_source_to_any_one_major_cities);
			
		}
		
		long min_distance_from_distination_to_any_one_major_cities = Long.MAX_VALUE;
		
		for(int i = 0; i < k; ++i) {
			
			long distance = city[i].distance(distination);
			
			min_distance_from_distination_to_any_one_major_cities = Math.min(distance, min_distance_from_distination_to_any_one_major_cities);
			
		}
		
		long source_to_distination = source.distance(distination);
		
		if(k == 0) {
			
			System.out.println(source_to_distination);
			
		} else {
			
			long min_cost = Math.min(source_to_distination, min_distance_from_distination_to_any_one_major_cities + min_distance_from_source_to_any_one_major_cities);
			
			System.out.println(min_cost);
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		k = in.nextInt();
		
		a = in.nextInt();
		
		b = in.nextInt();
		
		x = new long[n];
        y = new long[n];
        
        for(int i = 0; i < n; ++i) {
			
			x[i] = in.nextLong();
			y[i] = in.nextLong();
			
		}	
		
	}
	
	static class City {
		
		long X, Y;
		
		boolean major = false;
		
		public City(long X, long Y) {
			
			this.X = X;
			this.Y = Y;
			
		}
		
		long distance(City c) {
			
			long distance = Math.abs(this.X - c.X) + Math.abs(this.Y - c.Y);
			
			return distance;
			
		}
		
	}
	
}