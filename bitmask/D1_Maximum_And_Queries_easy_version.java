import java.util.Scanner;

public class D1_Maximum_And_Queries_easy_version {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static long a[], k[];
	
	static void solve(int index) {
		
		long max_bit = (1L << 60);
		
		long b[] = new long[n];
		
		long value = 0L;
		
		for(int i = 0; i != n; ++i) {
			
			b[i] = a[i];
			
		}
		
		for(int bit = 60; bit >= 0; --bit) {
			
			long operation = 0L;
			
			for(int i = 0; i != n; ++i) {
				
				operation += Math.max(max_bit - b[i], 0L);
				
				if(operation > k[index]) {
					
					break;
					
				}
				
			}
			
			if(k[index] >= operation) {
				
				value += max_bit;
				
				k[index] -= operation;
				
				for(int i = 0; i != n; ++i) {
					
					b[i] = Math.max(b[i], max_bit);
					
				}
				
			}
			
			for(int i = 0; i != n; ++i) {
				
				b[i] = (b[i] % max_bit);
				
			}
			
			max_bit = (max_bit >> 1);
			
			if(max_bit <= 0) {
				
				break;
				
			}
			
		}
		
		System.out.println(value);
		
	}
	
	public static void main(String [] priya) {
		
		input();
		
		for(int i = 0; i != testCases; ++i) {
			
			k[i] = in.nextLong();
			solve(i);
			
		}
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		testCases = in.nextInt();
		
		a = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextLong();
			
		}
		
		k = new long[testCases];
		
	}
	
}