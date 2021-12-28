import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B_Berland_Music {
    
    static Scanner in=new Scanner(System.in);
    
    static int testCases,n;
    
    static long a[];
    
    static char s[];
    
    static void solve(){
        
        List<element> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
			
			list.add(new element(a[i],i,s[i]-'0' ) );
			
		}
        
        List<element> orginal=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            orginal.add(list.get(i) );
            
        }
        
        Collections.sort(list);
	
        Map<Long,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            
            list.get(i).final_Position=i+1;
            
         //   map.put(list.get(i).ai,list.get(i).final_Position );
            
        }
	
        /*for(element i: list){
        System.out.println(i.ai+" "+i.liked+" "+i.final_Position);
        }*/
        list.forEach((i) -> {
            map.put(i.ai,i.final_Position );
        });
        
        orginal.forEach((i) -> {
            System.out.print( map.get(i.ai)+" ");
        });
		
        System.out.println();
        
    }
    
    public static void main(String[] amit) {
        
        testCases=in.nextInt();
        
        for(int t=0;t<testCases;t++){
            
            n=in.nextInt();
            
            a=new long[n];
            
            for(int i=0;i<n;i++){
                
                a[i]=in.nextLong();
                
            }
            
            s=in.next().toCharArray();
            
            solve();
            
        }
        
    }
    
    static class element implements Comparable<element> {
        
        long ai;
        int i,liked,final_Position;

        public element(long ai, int i,int liked) {
            this.ai = ai;
            this.i = i;
	    this.liked=liked;
        }

        @Override
        public int compareTo(element t) {
   //         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
		   if(this.liked!=t.liked ){
			   
			   return Integer.compare(this.liked,t.liked );
			   
		   }
		   
           return Long.compare(ai, t.ai);
   
        }
        
    }
    
}
/*

3
2
1 2
10
3
3 1 2
111
8
2 3 1 8 5 4 7 6
01110001


*/

/*

1
8
2 3 1 8 5 4 7 6
01110001


*/