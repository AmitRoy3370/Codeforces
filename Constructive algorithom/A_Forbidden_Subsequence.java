import java.util.Arrays;
import java.util.Scanner;

public class A_Forbidden_Subsequence {

    static Scanner in=new Scanner(System.in);
    
    static int testCases;
    
    static char s[],t[];
    
    static void solve(){
        
        int n=s.length,m=t.length;
        
        StringBuilder extra=new StringBuilder();
        
        int count[]=new int[3];
        
        Arrays.sort(s);
        
        for(char i: s){
            
            switch (i) {
                case 'a':
                    count[0]++;
                    break;
                case 'b':
                    count[1]++;
                    break;
                case 'c':
                    count[2]++;
                    break;
                default:
                    extra.append(i);
                    break;
            }
            
        }
        
       char e[]=extra.toString().toCharArray();
        
       Arrays.sort(e);
       
  //     Arrays.sort(t);
       
        if(count[0]==0 && count[1]==0 && count[2]==0 ){
            
            System.out.println(extra.toString());
            
            return;
            
        }
        
       
        if(!new String(t).equalsIgnoreCase("abc") || count[0]==0 ){
            
            Arrays.sort(s);
            
            System.out.println(new String(s) );
            
            return;
            
        }
            
        StringBuilder ans=new StringBuilder();
        
        int haveA=0;
        
        while(haveA<count[0]){
            
            ans.append('a');
            
            haveA++;
            
        }
        
        int haveC=0;
        
        while(haveC<count[2] ){
            
            ans.append('c');
            
            haveC++;
            
        }
        
        int haveB=0;
        
        while(haveB<count[1]){
            
            ans.append('b');
            
            haveB++;
            
        }
        
        if(extra.length()!=0 ){
          
            ans.append(new String(e) );
            
        }
        
        System.out.println(ans.toString());
        
    }
    
    public static void main(String[] args) {
        
        testCases=in.nextInt();
        
        for(int t1=0;t1<testCases;t1++){
            
            s=in.next().toCharArray();
            
            t=in.next().toCharArray();
            
            solve();
            
        }
        
    }
    
}
/*

7
abacaba
abc
cccba
acb
dbsic
bac
abracadabra
abc
dddddddddddd
cba
bbc
abc
ac
abc


*/

/*

1
abacaba
abc

*/

/*

1
dbsic
bac

*/

/*

1
cccba
acb

*/