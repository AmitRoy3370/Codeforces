
import java.util.Scanner;

public class A_Stable_Arrangement_of_Rooks {

    static Scanner in=new Scanner(System.in);

    static int testCases,n,rooks;

    static void solve(){

           if(n==1 && rooks==1){

              System.out.println("R");
              return;

           }

           if(rooks>(n+1)/2 ){ 
               
               System.out.println(-1);

               return;

            }

            char ans[][]=new char[n][n];

            for(int i=0;i<n;i++){

               for(int j=0;j<n;j++){

                    ans[i][j]='.';

               }

            }

            int index=0;

            for(int i=0;i<rooks;i++){

                 ans[index][index]='R';
                 ++index;
                 ++index;

            }

            for(char i[]: ans){

                for(char j: i){
 
                    System.out.print(j);

                }

                System.out.println();

            }

    }

    public static void main(String [] amit){

        testCases=in.nextInt();

        for(int t=0;t<testCases;t++){

             n=in.nextInt();
             rooks=in.nextInt();

             solve();

        }

    }

}
