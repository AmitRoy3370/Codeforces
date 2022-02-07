import java.util.Scanner;

public class A_Important_Exam {

    static Scanner in = new Scanner(System.in);

    static int n, m;

    static char a[][];

    public static void main(String[] amit) {
    
        n=in.nextInt();
        m=in.nextInt();
        
        a=new char[n][m];

        for(int i=0;i<n;i++){

            a[i]=in.next().toCharArray();

        }

        int score[]=new int[m];

        for(int i=0;i<m;i++) score[i]=in.nextInt();

        int ans=0;

        for(int i=0;i<m;i++){

            int count[]=new int[6];

            int max=0;

            for(int j=0;j<n;j++){

                count[a[j][i]-'A']++;

                max=Math.max(max, count[a[j][i]-'A']);

            }

            ans+=max*score[i];

        }

        System.out.println(ans);

    }

}
