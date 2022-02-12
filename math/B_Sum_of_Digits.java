import java.util.Scanner;

public class B_Sum_of_Digits {

    static Scanner in=new Scanner(System.in);

    public static void main(String[] amit) {
        
        char a[]=in.next().toCharArray();

        int n=a.length;

        if(n==1){

            System.out.println(0);
            return;

        }

        long sum=0;

        for(int i=0;i<n;i++){

            sum+=(a[i]-'0');

        }

        int count=1;

        while(sum>=10){

            long ans=sum;

            sum=sum(ans);

            ++count;

        }

        System.out.println(count);

    }

    static long sum(long n){

        int sum=0;

        char a[]=String.valueOf(n).toCharArray();

        for(char i: a){

            sum+=(i-'0');

        }

        return sum;

    }

}
