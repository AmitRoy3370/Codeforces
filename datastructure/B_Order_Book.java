import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class B_Order_Book {
    
     static int n,depth;

     static List<product> buy=new ArrayList<>();

     static List<product> sell=new ArrayList<>();

     static Scanner in=new Scanner(System.in);

   public static void main(String [] amit){

        n=in.nextInt();
        depth=in.nextInt();

        for(int i=0;i<n;i++){

             char direction=in.next().charAt(0);
             long price=in.nextLong();
             long quantity=in.nextLong();

             product p=new product(direction,quantity,price ) ;

             if(direction=='B'){

                if(buy.isEmpty()){

                    buy.add(p);
                    continue;

                } 

                int change=0;
                 
                for(product p1: buy){

                    if(equals(p1,p) ){

                        buy.get(buy.indexOf(p1)).quantity+=p.quantity;

                        change=1;

                        continue;

                    }

                }
                
                if(change!=1) buy.add(p);

             }else{

                if(sell.isEmpty()){

                    sell.add(p);
                    continue;

                }

                int change=0;

                for(product p1: sell){

                    if(equals(p1,p) ){

                        sell.get(sell.indexOf(p1)).quantity+=p.quantity;

                        change=1;

                        continue;

                    }

                }

                if(change!=1) sell.add(p);

             }

        }

        Collections.sort(buy);
        Collections.sort(sell);

        /*System.out.println("buy: ");

        for(product p: buy) System.out.println(p.toString());

        System.out.println("sell");

        for(product p: sell) System.out.println(p.toString());

        System.out.println("ans");*/

        /*try{

         for(int i=0;i<depth;i++) System.out.println(sell.get(i).toString() );

        }catch(Exception e){

        }

        try{

            for(int i=0;i<depth;i++) System.out.println(buy.get(i).toString() );
   
           }catch(Exception e){
   
           }*/

        int x=buy.size(),y=0;

        String ans="";

        for(product i: buy){

            ++y;

            if(x-y<depth ){

               ans=i.toString()+ans;

            }

        }

        y=0;

        for(product i: sell){

             ++y;

             if(y<=depth) ans=i.toString()+ans;

        }

        System.out.println(ans);


   }

   static class product implements Comparable<product> {

      long quantity,price;
      char directions;

      public product(char direction,long quantity,long price){

          this.price=price;
          this.quantity=quantity;
          this.directions=direction;

      }

      public int compareTo(product t){
           
           if(this.price>t.price) return 1;
           else if(this.price<t.price) return -1;

           return 0;
      
        }

        public String toString(){

           return directions+" "+price+" "+quantity+"\n";

        }

   }

   static boolean equals(product a,product b){

           return a.price==b.price;

   }

}
