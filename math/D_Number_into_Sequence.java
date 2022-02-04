//D_Number_into_Sequence

public class D_Number_into_Sequence {

    public static void main(String[] amit) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        for (int t = sc.nextInt(); t-- > 0;) {

            long n = sc.nextLong(), max = 1, m = 0, c = 0, x = n;

            for (long i = 2; i * i <= n; c = 0, i++) {

                while (n % i == 0) {
                    c++;
                    n /= i;
                }

                if (c > max) {
                    max = c;
                    m = i;
                }

            }

            for (sb.append(max).append("\n"); max-- > 1; sb.append(m).append(" ")) {
                x /= m;
            }

            sb.append(x).append("\n");

        }

        System.out.println(sb);

    }

}
