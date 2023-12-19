import java.util.Scanner;

public class C_Game_with_Multiset {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases, n;
	
	static int a[];
	
	static long b[];
	
	static void solve() {
		
		int bit_count[] = new int[31];
		
		for(int i = 0; i != n; ++i) {
			
			if(a[i] == 1) {
				
				bit_count[(int)b[i]]++;
				
			} else {
				
				long need = b[i];
				
				boolean find = false;
				
				for(int bit = 30; bit >= 0; --bit) {
					
					long bit_value = pow(2L, (long)bit);
					
					long bit_we_need = need / bit_value;
					
					long have = bit_count[bit];
					
					long actually_use = Math.min(bit_we_need, have);
					
					need -= actually_use * bit_value;
					
					if(need == 0) {
						
						find = true;
						break;
						
					}
					
				}
				
				if(find) {
					
					System.out.println("YES");
					
				} else {
					
					System.out.println("NO");
				
				}
				
			}
			
		}
		
	}
	
	public static void main(String [] priya) {
		
		input();
		solve();
		
	}
	
	private static void input() {
		
		n = in.nextInt();
		
		a = new int[n];
		b = new long[n];
		
		for(int i = 0; i != n; ++i) {
			
			a[i] = in.nextInt();
			b[i] = in.nextLong();
			
		}
		
	}
	
    static long pow(long value, long power) {
 
        long pow_value = 1L;
 
        while (power > 0L) {
 
            if (power % 2L == 1L) {
 
                pow_value *= value;
 
            }
 
            value *= value;
 
            power /= 2L;
 
        }
 
        return pow_value;
 
    }
 
}