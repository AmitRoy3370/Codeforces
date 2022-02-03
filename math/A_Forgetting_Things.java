import java.util.Scanner;

public class A_Forgetting_Things {

    static Scanner in = new Scanner(System.in);

    static int a, b;

    public static void main(String[] amit) {

        a = in.nextInt();
        b = in.nextInt();

        if (Math.abs(a - b) != 1) {

            if (a == b)
                System.out.println(a + "1" + " " + b + "2");
            else if ((a == 9 && b == 1))
                System.out.println(a + " " + b + "0");
            else if (a == 1 && b == 9)
                System.out.println(-1);
            else
                System.out.println(-1);

        } else {

            if (a == b)
                System.out.println(a + "1" + " " + b + "2");
            else if (a > b)
                System.out.println(-1);
            else
                System.out.println(a + " " + b);

        }

    }

}
