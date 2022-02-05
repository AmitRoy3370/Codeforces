import java.util.Scanner;

public class M_Weather_Tomorrow {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int n = in.nextInt();

        long a[] = new long[n];

        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();

        long diff = a[1] - a[0];

        if (n == 2)
            System.out.println((a[n - 1] + diff));
        else {

            for(int i=2;i<n;i++){

                long diff1=a[i]-a[i-1];

                if(diff!=diff1 ){

                    System.out.println(a[n-1]);
                    return;

                }

                diff=diff1;

            }

            System.out.println((a[n-1]+diff) );

        }

    }

}
