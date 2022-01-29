import java.util.Scanner;
import java.util.Arrays;

public class B_Game_of_Credit_Cards {

    static Scanner in=new Scanner(System.in);

    static int n;

    static char sherlock[],moriarty[];
    
   public static void main(String [] amit) {

      n=in.nextInt();

      sherlock=in.next().toCharArray();
      moriarty=in.next().toCharArray();

      Arrays.sort(sherlock);
      Arrays.sort(moriarty);

      int max=0,min=0,i=0,j=0;

      while(i<n && j<n){

        if((moriarty[j]-'0')>(sherlock[i]-'0') ){

            min++;
            ++i;
            ++j;

        }else ++j;

      }

      i=0;
      j=0;

      while(i<n && j<n){

        if((moriarty[j]-'0')>=(sherlock[i]-'0')){

            ++max;
            ++i;
            ++j;

        }else ++j;

      }

      System.out.println((n-max)+"\n"+min);
       
   }

}
