import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_The_Festive_Evening {

    static Scanner in=new Scanner(System.in);
    
    static char guests[];
    
    static int guest,gard;
    
    public static void main(String[] amit) {
        
        guest=in.nextInt();
        gard=in.nextInt();
        
        guests=in.next().toCharArray();
        
        int disMiss=0;
        
        Map<Character,int[] > guest_schedule=new HashMap<>();
        
        for(int i=0;i<guest;i++){
            
            if(guest_schedule.containsKey(guests[i]) ){
                
                  guest_schedule.get(guests[i])[1]=i;
                
            }else{
                
                guest_schedule.put(guests[i],new int[2]  );
                
                guest_schedule.get(guests[i])[0]=i;
                guest_schedule.get(guests[i])[1]=i;
                
            }
            
        }
        
        schedule time_table[]=new schedule[guest_schedule.size()];
        
        int index=0;
        
        for(char i: guest_schedule.keySet()){
            
            time_table[index++]=new schedule(i,guest_schedule.get(i)[0],guest_schedule.get(i)[1] );
            
        }
        
        Arrays.sort(time_table);
        
        /*for(schedule i: time_table){
            
            System.out.println(i.guest+" "+i.start+" "+i.end);
            
        }*/
        
        int n=time_table.length;
        
        Map<Character,Boolean> active=new HashMap<>();
        
     
        for(int i=0;i<guest;i++){
            
          active.put(guests[i], Boolean.TRUE);
            
          if(active.size()>gard ){
              
              System.out.println("YES");
              
              return;
              
          }
          
          if(guest_schedule.get(guests[i])[1]==i ){
              
              active.remove(guests[i]);
              
          }
          
        }
        
        System.out.println("NO");
        
    }
    
    static class schedule implements Comparable<schedule> {
        
        char guest;
        int start,end;

        public schedule(char guest, int start, int end) {
            this.guest = guest;
            this.start = start;
            this.end = end;
        }

        public char getGuest() {
            return guest;
        }

        public void setGuest(char guest) {
            this.guest = guest;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(schedule t) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    return this.start-t.start;
    
        }
        
    }
    
}
/*

5 1
AABBB


*/

/*

5 1
ABABB


*/

/*

8 3
ABCBCDCA

*/