
import java.util.Scanner;

public class A_Exams {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] amit) {

        int n = in.nextInt();
        int m = in.nextInt();

        if (m >= 3 * n) {

            System.out.println(0);

        } else {

            System.out.println(3 * n - m);

        }

    }

}
