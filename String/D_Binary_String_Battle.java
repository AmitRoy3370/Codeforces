import java.util.Scanner;

public class D_Binary_String_Battle {
    
    static Scanner in = new Scanner(System.in);
    
    static int testCases, n, k;
    
    static char x[];
    
    static void solve() {
        
        int count[] = new int[2];
        
        for(char i : x) {
            
            count[i - '0']++;
            
        }
        
        if(count[1] >= k + 1 && n >= 2 * k) {
            
            System.out.println("Bob");
            
        } else {
            
            System.out.println("Alice");
            
        }
        
    }
    
    public static void main(String[] args) {
        
        testCases = in.nextInt();
        
        for(int t = 0; t < testCases; ++t) {
            
            input();
            solve();
            
        }
        
    }
    
    private static void input() {
        
        n = in.nextInt();
        k = in.nextInt();
        
        x = in.next().toCharArray();
        
    }
    
}
