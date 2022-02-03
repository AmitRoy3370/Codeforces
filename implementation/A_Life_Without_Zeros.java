import java.util.Scanner;

public class A_Life_Without_Zeros {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        long a = in.nextInt();
        long b = in.nextInt();

        long sum = a + b;

        char A[] = String.valueOf(a).toCharArray();
        char B[] = String.valueOf(b).toCharArray();
        char Sum[] = String.valueOf(sum).toCharArray();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (char i : A) {

            if (i != '0')
                sb1.append(i);

        }

        for (char i : B) {

            if (i != '0')
                sb2.append(i);

        }

        for (char i : Sum) {

            if (i != '0')
                sb3.append(i);

        }

        long newSum = Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString());
        long compSum = Long.parseLong(sb3.toString());

        if (newSum == compSum)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

}
