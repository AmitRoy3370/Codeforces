import java.util.Scanner;

public class A_Arrays {

    static Scanner in=new Scanner(System.in);

    static int nA,nB,k,m;

    static long a[],b[];

    static void solve(){

        if(a[k-1]<b[nB-m]) System.out.println("YES");
        else System.out.println("NO");

    }
    
   public static void main(String [] amit){

      nA=in.nextInt();
      nB=in.nextInt();

      k=in.nextInt();
      m=in.nextInt();

      a=new long[nA];
      b=new long[nB];

      for(int i=0;i<nA;i++) a[i]=in.nextLong();

      for(int i=0;i<nB;i++) b[i]=in.nextLong();

      solve();

   }

   static void sort(long a[],int left,int right){

      if(left>=right) return;

      int mid=(left+right)/2;

      sort(a,left,mid);

      sort(a,mid+1,right);

      merge(a, left, right, mid);

   }

   static void merge(long a[],int left,int right,int mid){

         int n1=(mid-left+1),n2=right-mid;

         long L[]=new long[n1];

         long R[]=new long[n2];

         for(int i=0;i<n1;i++){

             L[i]=a[left+i];

         }

         for(int i=0;i<n2;i++){

            R[i]=a[mid+1+i];

         }

         int k=left,i=0,j=0;

         while(i<n1 && j<n2){

               if(L[i]<=R[j] ){

                   a[k]=L[i];
                   ++i;

               }else{
                  
                   a[k]=R[j];
                   ++j;
                  
               }
               
               ++k;

         }

         while(i<n1){

            a[k]=L[i];

            ++i;
            ++k;

         }

         while(j<n2){

            a[k]=R[j];

            ++j;
            ++k;

         }

   }

}
