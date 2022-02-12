import java.util.Scanner;

public class A_Even_Substrings {
    
    static Scanner in=new Scanner(System.in);

    static int n;

    static char s[];
    
    static void solve(){

        if(n==1){

            System.out.println(((s[0]-'0')%2==0?1:0));
            return;

        }

        int ans=0;

        for(int i=0;i<n;i++){

            if((s[i]-'0')%2==0 ){

                ans+=i+1;

            }

        }

        System.out.println(ans);

    }

    public static void main(String[] amit) {

        n=in.nextInt();

        s=in.next().toCharArray();

        solve();

    }

}
