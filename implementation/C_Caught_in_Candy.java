import java.util.Scanner;

public class C_Caught_in_Candy {

    static Scanner in=new Scanner(System.in);

    static double h,k;

    static int n;

    static Axis axis[];

    public static void main(String[] amit) {

        n=in.nextInt();

        axis=new Axis[n];

        Axis center=new Axis(in.nextDouble(),in.nextDouble());

        for(int i=0;i<n;i++) axis[i]=new Axis(in.nextDouble(),in.nextDouble());

        double radious=distance(center, axis[0]);

        for(int i=1;i<n;i++) radious=Math.max(radious,distance(axis[i],center) );

        System.out.println(radious*2.0);
        
    }
    
    private static class Axis{

       double x,y;

       private Axis(double x, double y) {
        
        this.x = x;
        this.y = y;
       
       }

    }

    private static double distance(Axis first,Axis second){

        return Math.sqrt(Math.pow(first.x-second.x, 2)+Math.pow(first.y-second.y, 2) );

    }

}
