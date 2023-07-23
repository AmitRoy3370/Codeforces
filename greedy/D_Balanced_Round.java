import java.util.Scanner;

public class D_Balanced_Round {

      static int testCases, n;
   
      static long k;
   
      static long a[];
   
      static Scanner in = new Scanner(System.in);
   
      static void solve() {
          
          boolean already_ok = true;
          
          for(int i = 0; i < n - 1; ++i) {
               
               if(Math.abs(a[i + 1] - a[i]) <= k) {
                   
                   already_ok = true;
                   
               } else {
                   
                   already_ok = false;
                   break;
                   
               }
               
          }
          
          if(already_ok) {
             
             System.out.println("0");
             return;
             
          }
          
          sort(a, 0, n - 1);
          
          long first_comparator = a[0];
          
          int delete = 1, j = 0, actual_delete = 1;
          
          for(int i = 1; i < n; ++i) {
              
               if(i < n && Math.abs(a[j] - a[i]) > k) {
                   
                   delete = 1;
                   
               } else {
                   
                   ++delete;
                   
               }
               
               actual_delete = Math.max(actual_delete, delete);
               
               j = i;
               
          }
          
          n -= actual_delete;
          
          System.out.println(n);
       
      }

      public static void main(String [] amit) {
   
          testCases = in.nextInt();
       
          for(int t = 0; t < testCases; ++t) {
           
              input();
              solve();
           
          }
   
       }
   
       static void input() {
       
          n = in.nextInt();
       
          k = in.nextLong();
       
          a = new long[n];
       
          for(int i = 0; i < n; ++i) {
           
              a[i] = in.nextLong();
           
          }
       
       }
       
       static void merge(long a[], int left, int right, int mid) {
 
        int n1 = mid - left + 1, n2 = right - mid;
 
        long L[] = new long[n1];
 
        long R[] = new long[n2];
 
        for (int i = 0; i < n1; i++) {
 
            L[i] = a[left + i];
 
        }
 
        for (int i = 0; i < n2; i++) {
 
            R[i] = a[mid + 1 + i];
 
        }
 
        int i = 0, j = 0, k1 = left;
 
        while (i < n1 && j < n2) {
 
            if (L[i] <= R[j]) {
 
                a[k1] = L[i];
 
                i++;
 
            } else {
 
                a[k1] = R[j];
 
                j++;
 
            }
 
            k1++;
 
        }
 
        while (i < n1) {
 
            a[k1] = L[i];
 
            i++;
 
            k1++;
 
        }
 
        while (j < n2) {
 
            a[k1] = R[j];
 
            j++;
            k1++;
 
        }
 
    }
 
    static void sort(long a[], int left, int right) {
 
        if (left >= right) {
 
            return;
 
        }
 
        int mid = (left + right) / 2;
 
        sort(a, left, mid);
 
        sort(a, mid + 1, right);
 
        merge(a, left, right, mid);
 
    }
   
}
