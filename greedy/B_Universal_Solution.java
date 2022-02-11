
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class B_Universal_Solution {
    
    static Scanner in = new Scanner(System.in);
    
    static int testCases, n;
    
    static char a[];
    
    static Map<Character, Character> map = new HashMap<>();
    
    static void solve() {
        
        Map<Character, Integer> count = new HashMap<>();
        
        count.put('C', 0);
        count.put('S', 0);
        count.put('R', 0);
        
        for (char i : a) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        int maximumCount=0;
        
        Character c=null;
        
        for(char i: count.keySet()){
            
            if(maximumCount<count.get(i) ){
                
                maximumCount=count.get(i);
                
                c=i;
                
            }
            
        }
        
        c=map.get(c);
        
        for(int i=0;i<n;i++){
            
            System.out.print(c);
            
        }
        
        System.out.println();
        
    }
    
    public static void main(String amit[]) {
        
        testCases = in.nextInt();
        
        map.put('R', 'P');
        map.put('S', 'R');
        map.put('P', 'S');
        
        for (int t = 0; t < testCases; t++) {
            
            a = in.next().toCharArray();
            
            n = a.length;
            
            solve();
            
        }
        
    }
}
