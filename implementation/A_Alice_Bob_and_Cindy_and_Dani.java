import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import java.util.Map;
import java.util.HashMap;

public class A_Alice_Bob_and_Cindy_and_Dani {

    static Scanner in=new Scanner(System.in);
    
    static Map<String,Boolean> map=new HashMap<>();

    public static void main(String[] amit) {

        map.put("Alice", false);
        map.put("Bob", false);
        map.put("Cindy", false);
        map.put("Dani", false);
        
        map.put(in.next(), true);
        map.put(in.next(), true);
        map.put(in.next(), true);
        
        for(String i: map.keySet()) if(!map.get(i)) System.out.println(i);

    }
    
}
