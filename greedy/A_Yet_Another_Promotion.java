import java.util.Scanner;

public class A_Yet_Another_Promotion {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long a, b, n, m;
	
	/*
	
	a : the price of the first day.
	b : the price of the second day.
	n : me wanted to buy.
	m : for each m kilo's me gifted a 1 kilo.
	
	has to detect the min cost for the n kilo of the
	potato's.
	
	bonoused 1 kilo for the every 5 kilo of the
	potato, this is only for the 1st day.
	
	eg1:
	
	a	b
	5	4
	n	m
	3	1
	
	first day: baught 1 kilo and get 1 kilo bonous.
	so the cost is :- 5
	
	second day: baught 1 kilo and give the price
	4.
	
	so the total cost is : 5 + 4 = 9
	
	eg2:
	
	5	4 = (a	b)
	3	2 = (n	m)
	
	5 + 5(get 1 kilo bonous) = 10
	
	eg3:
	
	3 4
	3 5
	
	3 + 3 + 3 = 9
	
	*/
	
	static void solve() {
		
		long bonous = n / (m + 1L);
		
		long remain = n - bonous * (m + 1);
		
		long ans = bonous * Math.min(a * m, b * (m + 1)) + remain * Math.min(a, b);
		
		System.out.println(ans);
		
	}
	
	public static void main(String [] priya) {
		
		testCases = in.nextInt();
		
		for(int t = 0; t < testCases; ++t) {
			
			a = in.nextLong();
			b = in.nextLong();
			
			n = in.nextLong();
			m = in.nextLong();
			
			solve();
			
		}
		
	}
	
}