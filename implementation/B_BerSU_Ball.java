
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_BerSU_Ball {

    static int n,m;
    
    static Scanner in=new Scanner();
    
    static PrintWriter out=new PrintWriter(System.out);
    
    static int boys[];
    
    static int girls[];
    
    static void merge(int a[],int left,int right,int mid){
        
        int n1=mid-left+1,n2=right-mid;
        
        int L[]=new int[n1];
        
        int R[]=new int[n2];
        
        for(int i=0;i<n1;i++){
            
            L[i]=a[left+i];
            
        }
        
        for(int i=0;i<n2;i++){
            
            R[i]=a[mid+1+i];
            
        }
        
        int i=0,j=0,k=left;
        
        while(i<n1 && j<n2){
            
            if( L[i]<=R[j] ){
                
                a[k]=L[i];
                
                i++;
                
            }else{
            
            a[k]=R[j];
            
            j++;
            
                  }
            
            k++;
            
        }
        
        while(i<n1){
            
        a[k]=L[i];
            
        k++;
            i++;
        
        }
        
        while(j<n2){
            
            a[k]=R[j];
            
            j++;
            k++;
            
        }
        
    }
    
    static void sort(int a[],int left,int right){
        
        if(left>=right){
            
            return;
            
        }
        
        int mid=(left+right)/2;
        
        sort(a,left,mid);
        
        sort(a,mid+1,right);
        
        merge(a,left,right,mid);
        
    }

static void print(int a[]){
    
    for(int i: a){
        
        out.print(i+" ");
        out.flush();
        
    }
    
    out.println();
    out.flush();
    
}
    
    public static void main(String[] amit) throws IOException {
        
        n=in.nextInt();
        
        boys=new int[n];
        
        for(int i=0;i<n;i++){
            
            boys[i]=in.nextInt();
            
        }
        
        m=in.nextInt();

girls=new int[m];
        
        for(int i=0;i<m;i++){
            
            girls[i]=in.nextInt();
            
        }
        
        sort(boys,0,n-1);
        
        sort(girls,0,m-1);

       // print(boys);
        //print(girls);
        
boolean vis[]=new boolean[n];
boolean vis1[]=new boolean[m];        

        int counter=0;
        
       for(int i=0;i<n;i++){
           
           for(int j=0;j<m;j++){
               
               if(Math.abs(boys[i]-girls[j])<=1 && !vis[i] && !vis1[j]  ){
                   
                   vis[i]=true;
                   vis1[j]=true;
                   
                   counter++;
            
                   break;
                   
               }
               
           }
           
       }
        
       out.println(counter);
       out.flush();
       
    }
    
    static class Scanner{
        
        BufferedReader in;
        StringTokenizer st;

        public Scanner() {
        
            in=new BufferedReader( new InputStreamReader(System.in) );
            
        }
        
        String next() throws IOException{
            
            while(st==null || !st.hasMoreElements()){
                
                st=new StringTokenizer( in.readLine() );
                
            }
            
            return st.nextToken();
            
        }
        
        String nextLine() throws IOException{
            
            return in.readLine();
            
        }
        
        int nextInt() throws IOException{
            
            return Integer.parseInt(next());
            
        }
        
        double nextDouble() throws IOException{
            
            return Double.parseDouble( next() );
            
        }
        
        long nextLong() throws IOException{
            
            return Long.parseLong(next());
            
        }
        
    }
    
}
/*

4
1 4 6 2
5
5 1 5 7 9

*/

/*

4
1 2 3 4
4
10 11 12 13


*/

/*

5
1 1 1 1 1
3
1 2 3


*/

/*

4
1 2 1 3
1
4

*/