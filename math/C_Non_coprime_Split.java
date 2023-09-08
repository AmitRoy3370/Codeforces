import java.util.Scanner;

public class C_Non_coprime_Split {
	
	static Scanner in = new Scanner(System.in);
	
	static int testCases;
	
	static long L, R;
	
	static long seive[];
	
	static void solve() {
		
		if(R < 4) {
			
			System.out.println(-1);
			
		} else if(L == R) {
			
			if(seive[(int)L] == L) {
				
				System.out.println(-1);
				
			} else {
				
				System.out.println(seive[(int)L] + " " + (L - seive[(int)L]));
				
			}
			
		} else if(R % 2 == 0) {
			
			System.out.println(2 + " " + (R - 2));
			
		} else {
			
			System.out.println(2 + " " + (R - 3));
			
		}
		
	}
	
	public static void main(String [] amit) {
		
		testCases = in.nextInt();
		
		seive();
		
		for(int t = 0; t < testCases; ++t) {
			
			input();
			solve();
			
		}
		
	}
	
	private static void input() {
		
		L = in.nextLong();
		
		R = in.nextLong();
		
	}
	
    static void seive() {
 
        seive = new long[10000001];
 
        int n = 10000001;
        
        for(int i = 1; i < n; ++i) {
            
            seive[i] = i;
            
        }
 
        for (int i = 2; i * i <= n; ++i) {
 
            if(seive[i] == i) {
                
                for(int j = i * i; j < n; j += i) {
                    
                    seive[j] = i;
                    
                }
                
            }
            
        }
 
    }
 
}