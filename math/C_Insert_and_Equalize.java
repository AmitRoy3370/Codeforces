import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class C_Insert_and_Equalize {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[];
	
	static void solve() {
		
		if(n == 1) {
			
			System.out.println(1);
			return;
			
		}
		
		List<Long> list = new ArrayList<>();
		
		for(long i : a) {
			
			list.add(i);
			
		}
		
		Collections.sort(list);
		
		long max = list.get(n - 1);
		
		long x = 0L;
		
		for(long i : list) {
			
			if(i == max) {
				
				break;
				
			}
			
			x = gcd(x, max - i);
			
		}
		
		long operation = 1L;
		
		for(long i : list) {
			
			operation += (max - i) / x;
			
		}
		
		long last_value = max - x;
		
		for(int i = n - 2; i >= 0; --i) {
			
			if(last_value != list.get(i)) {
				
				break;
				
			}
			
			last_value -= x;
			
			++operation;
			
		}
		
		System.out.println(operation);
		
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
		
		a = new long[n];
		
		for(int i =0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
	}
	 
	private static long gcd(long a, long b) {
        
        if (a == 0)
            return b;
 
        return gcd(b % a, a);
    
    }
 
}