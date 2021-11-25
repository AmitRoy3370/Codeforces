
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Make_Even {

    static Scanner in=new Scanner();
    
    static PrintWriter out=new PrintWriter( new OutputStreamWriter(System.out) );
    
    static int testCases,n;
    
    static char a[];
    
    static void solve(){
        
        if(Long.parseLong(new String(a))%2==0 ){
            
            out.println(0);
            out.flush();
            
            return;
            
        }
        
        if(n==1 && Long.parseLong(new String(a))%2==1){
            
            out.println(-1);
            out.flush();
            
            return;
            
        }
        
        if((a[0]-'0')%2==0 ){
            
            out.println(1);
            out.flush();
            
            return;
            
        }
        
        int index=-1;
        
        for(int i=0;i<n;i++){
            
            if((a[i]-'0')%2==0 ){
                
                index=i;
                
                break;
                
            }
            
        }
        
        if(index==-1){
            
            out.println(-1);
            out.flush();
            
        }else{
            
            out.println((2) );
            out.flush();
            
        }
        
    }
    
    public static void main(String[] amit) throws IOException,ArrayIndexOutOfBoundsException {
        
        testCases=in.nextInt();
        
        for(int t=0;t<testCases;t++){
            
            a=in.next().toCharArray();
            
            n=a.length;
            
            solve();
            
        }
        
        in.close();
        
    }
           
   static class Node<T>{
    
    T data;
    
    Node<T> next;

    public Node() {
    
        this.next=null;
    
    }

    public Node(T data) {
        
        this.data = data;
    
        this.next=null;
        
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    @Override
    public String toString(){
        
        return this.getData().toString()+"  ";
        
    }
    
}

   static class ArrayList<T>{
           
    Node<T> head,tail;
    
    int len;

    public ArrayList() {
    
    this.head=null;    
        
    this.tail=null;
    
    this.len=0;
    
    }
    
    int size(){
        
        return len;
        
    }
    
    boolean isEmpty(){
        
        return len==0;
        
    }
    
    int indexOf(T data){
        
        if( isEmpty() ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        Node<T> temp=head;
        
        int index=0,i=0;
        
        while(temp!=null){
            
            if( temp.getData()==data ){
                
                index=i;
                
            }
            
            i++;
            
            temp=temp.getNext();
            
        }
        
        return index;
        
    }
    
    void add(T data){
        
        Node<T> newNode=new Node<>(data);
        
        if( isEmpty() ){
            
            head=newNode;
            
            tail=newNode;
            
            len++;
            
        }else{
        
        tail.setNext(newNode);
            
        tail=newNode;
        
        len++;
        
        }
        
    }
    
    void see(){
        
        if( isEmpty() ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        Node<T> temp=head;
        
        while( temp!=null ){
            
            out.print(temp.getData().toString()+" ");
            out.flush();
            
            temp=temp.getNext();
            
        }
        
        out.println();
        out.flush();
        
    }
            
    void inserFirst(T data){
        
        Node<T> newNode=new Node<>(data);
        
        Node<T> temp=head;
        
        if( isEmpty() ){
            
            head=newNode;
            tail=newNode;
            
            len++;
            
        }else{
            
            newNode.setNext(temp);
            
            head=newNode;
            
            len++;
            
        }
        
    }
    
    T get(int index){
        
        if( isEmpty() || index>=len ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        Node<T> temp=head;
        
        int i=0;
        
        T data=null;
        
        while(temp!=null){
            
            if( i==index ){
                
                data=temp.getData();
                
            }
            
            i++;
            
            temp=temp.getNext();
            
        }
        
        return data;
        
    }
    
    void addAt(T data,int index){
        
        if( index>=len ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        Node<T> newNode=new Node<>(data);
        
        int i=0;
        
        Node<T> temp=head;
        
        while( temp.next!=null ){
            
            if(i==index){
                
                newNode.setNext(temp.next);
                
                temp.next=newNode;
                
            }
            
            i++;
            
            temp=temp.getNext();
            
        }
        
    //    temp.setNext(temp);
        
        len++;
        
    }
    
    void popFront(){
        
        if( isEmpty() ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        if( head==tail ){
            
            head=null;
            tail=null;
            
        }else{
            
            head=head.getNext();
            
        }
        
        len--;
        
    }
    
    void removeAt(int index){
        
        if( index>=len ){
            
            throw new ArrayIndexOutOfBoundsException();
            
        }
        
        if(index==0){
            
            this.popFront();
            
            return;
            
        }
        
        Node<T> temp=head;
        
        int i=0;
        
        Node<T> n=new Node<>();
        
        while(temp!=null){
            
            if(i==index){
                
                n.next=temp.next;
                
                temp.next=n;
                
                break;
                
            }
            
            i++;
            
            n=temp;
            
            temp=temp.getNext();
            
        }
        
        tail=n;
        
        --len;
        
    }
    
    void clearAll(){
        
        this.head=null;
        this.tail=null;
        
    }
       
   }
   
    static long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
	
   static void merge(long a[],int left,int right,int mid){
        
        int n1=mid-left+1,n2=right-mid;
        
        long L[]=new long[n1];
        
        long R[]=new long[n2];
        
        for(int i=0;i<n1;i++){
            
            L[i]=a[left+i];
            
        }
        
        for(int i=0;i<n2;i++){
            
            R[i]=a[mid+1+i];
            
        }
        
        int i=0,j=0,k1=left;
        
        while(i<n1 && j<n2){
            
            if( L[i]<=R[j] ){
                
                a[k1]=L[i];
                
                i++;
                
            }else{
                
                a[k1]=R[j];
                
                j++;
                
            }
            
            k1++;
            
        }
        
        while(i<n1){
            
            a[k1]=L[i];
            
            i++;
            
            k1++;
            
        }
        
        while(j<n2){
            
            a[k1]=R[j];
            
            j++;
            k1++;
            
        }
        
    }
    
    static void sort(long a[],int left,int right){
        
        if(left>=right){
            
            return;
            
        }
        
        int mid=(left+right)/2;
        
        sort(a,left,mid);
        
        sort(a,mid+1,right);
        
        merge(a,left,right,mid);
        
    }
	
    static class Node1<T>{
        
        T data;
        
        Node1 next;

        public Node1(T data) {
            this.data = data;
        
            this.next=null;
            
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node1 getNext() {
            return next;
        }

        public void setNext(Node1 next) {
            this.next = next;
        }
        
    }
    
    static class Stack<T>{
        
        int len;
        
        Node1<T> node;

        public Stack() {
        
            len=0;
            
            node=null;
            
        }
        
        boolean isEmpty(){
            
            return len==0;
            
        }
        
        int size(){
            
            return len;
            
        }
        
        void push(T data){
            
            Node1<T> temp=new Node1<>(data);
            
            temp.setNext(this.node);
            
            node=temp;
            
            len++;
            
        }
        
        T top(){
            
            if( isEmpty() ){
                
                throw new ArrayIndexOutOfBoundsException();
                
            }
            
            return this.node.getData();
            
        }
        
        T pop(){
            
            if( isEmpty() ){
                
                throw new ArrayIndexOutOfBoundsException();
                
            }
            
            T data=this.node.getData();
            
            this.node=this.node.getNext();
            
            len--;
            
            return data;
            
        }
        
    }
    
	  static class Scanner{
        
        BufferedReader in;
        StringTokenizer st;

        public Scanner() {
        
            in=new BufferedReader( new InputStreamReader(System.in) );
            
        }
        
        String next() throws IOException{
            
            while(st==null || !st.hasMoreElements()){
                
                st=new StringTokenizer(in.readLine());
                
            }
            
            return st.nextToken();
            
        }
        
        int nextInt() throws IOException{
            
            return Integer.parseInt(next());
            
        }
        
        long nextLong() throws IOException{
            
            return Long.parseLong(next());
            
        }
        
        String nextLine() throws IOException{
            
            return in.readLine();
            
        }
        
        char nextChar() throws IOException{
            
            return next().charAt(0);
            
        }
        
        double nextDouble() throws IOException{
            
            return Double.parseDouble(next());
            
        }
        
        float nextFloat() throws IOException{
            
            return Float.parseFloat(next());
            
        }
        
        boolean nextBoolean() throws IOException{
            
            return Boolean.parseBoolean(next());
            
        }
        
        void close() throws IOException{
            
            in.close();
            
        }
        
    }
	
}
/*

4
3876
387
4489
3


*/