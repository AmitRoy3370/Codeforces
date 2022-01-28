
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class B_Integers_Shop {
   
   static Scanner in = new Scanner();

   static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

   static int testCases,n;

   static range a[];

   static void solve(){

       //store the initial cost and range

       long initial_left=a[0].left,initial_right=a[0].right,initial_cost=a[0].cost,initial_len=initial_right-initial_left+1,initial_cost_left=a[0].cost,initial_cost_right=a[0].cost;

       out.println(initial_cost );//at the first state print the basic cost
       out.flush();

       //int previous_index=0;//this will collect the information of the index

       for(int i=1;i<n;i++){

            long new_left=a[i].left,new_right=a[i].right,new_cost=a[i].cost;//collect the new cost and range

            /*

                every step we find the left state and the right state, so our total cost is the summation to gain the left state cost and the right 
                right state cost
                every time we just check that the maximum range we can get from them
                and update the left sate cost and left state and also to the right state and right state cost according to the sitution 

            */
            
            //first we try to fund the minimum left state

            if(new_left<initial_left ){

                initial_left=new_left;
                initial_cost_left=new_cost;

            }

            if(initial_left==new_left){

                initial_cost_left=Math.min(initial_cost_left, new_cost);

            }

            if(initial_right<new_right){

                initial_right=new_right;
                initial_cost_right=new_cost;

            }

            if(initial_right==new_right) initial_cost_right=Math.min(initial_cost_right, new_cost);

            if(initial_len<new_right-new_left+1){ 
                
                initial_len=new_right-new_left+1;
                initial_cost=new_cost;
            
            }

            if(initial_len==new_right-new_left+1) initial_cost=Math.min(initial_cost, new_cost);
            
            long ans=initial_cost_left+initial_cost_right;

            if(initial_len==initial_right-initial_left+1) ans=Math.min(ans, initial_cost);

            out.println(ans);
            out.flush();
            
       }

   }
 
   public static void main(String [] amit) throws IOException {
       
       testCases=in.nextInt();

       for(int t=0;t<testCases;t++){

          n=in.nextInt();

          a=new range[n];

          for(int i=0;i<n;i++) a[i]=new range(in.nextLong(),in.nextLong(),in.nextLong() );

          solve();

       }

       in.close();

   }

   static class range implements Comparable<range>{

    long left,right,cost;
    
     public range(long left,long right,long cost){

        this.left=left;
        this.right=right;
        this.cost=cost;

     }
     
     @Override
     public int compareTo(range t){

        return Long.compare(this.cost, t.cost);

     }

   }

   static String sum(String a, String b) {

    StringBuilder ans = new StringBuilder();

    int n1 = a.length(), m = b.length();

    if (n1 > m) {

        String t = a;
        a = b;
        b = t;

    }

    n1 = a.length();
    m = b.length();

    StringBuilder str1 = new StringBuilder(a).reverse();
    StringBuilder str2 = new StringBuilder(b).reverse();

    char first[] = str1.toString().toCharArray();
    char second[] = str2.toString().toCharArray();

    int carry = 0;

    for (int i = 0; i < n1; i++) {

        int sum = (first[i] - '0') + (second[i] - '0') + carry;

        ans.append(sum % 10);

        carry = sum / 10;

    }

    for (int i = n1; i < m; i++) {

        int sum = (second[i] - '0') + carry;

        ans.append(sum % 10);

        sum /= 10;

    }

    if (carry > 0) {

        ans.append(carry);

    }

    ans.reverse();

    return ans.toString();

}

static String mul(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 == 0 || len2 == 0) {
        return "0";
    }

    int result[] = new int[len1 + len2];

    int i_n1 = 0;
    int i_n2 = 0;

    for (int i = len1 - 1; i >= 0; i--) {
        int carry = 0;
        int n1 = num1.charAt(i) - '0';

        i_n2 = 0;

        for (int j = len2 - 1; j >= 0; j--) {

            int n2 = num2.charAt(j) - '0';

            int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

            carry = sum / 10;

            result[i_n1 + i_n2] = sum % 10;

            i_n2++;
        }

        if (carry > 0) {
            result[i_n1 + i_n2] += carry;
        }

        i_n1++;
    }

    int i = result.length - 1;
    while (i >= 0 && result[i] == 0) {
        i--;
    }

    if (i == -1) {
        return "0";
    }

    String s = "";

    while (i >= 0) {
        s += (result[i--]);
    }

    return s;
}

static int multiply(int x, int res[], int res_size) {

    int carry = 0;

    for (int i = 0; i < res_size; i++) {
        int prod = res[i] * x + carry;

        res[i] = prod % 10;

        carry = prod / 10;
    }

    while (carry > 0) {
        res[res_size] = carry % 10;
        carry = carry / 10;
        res_size++;
    }
    return res_size;
}

static long power(int x, int n) {

    int MAX = 100000;

    if (n == 0) {

        return 1;
    }
    int res[] = new int[MAX];
    int res_size = 0;
    int temp = x;

    while (temp != 0) {
        res[res_size++] = temp % 10;
        temp = temp / 10;
    }

    for (int i = 2; i <= n; i++) {
        res_size = multiply(x, res, res_size);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = res_size - 1; i >= 0; i--) {
        sb.append(res[i]);
    }

    return Long.parseLong(sb.toString());

}

static class Node<T> {

    T data;

    Node<T> next;

    public Node() {

        this.next = null;

    }

    public Node(T data) {

        this.data = data;

        this.next = null;

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
    public String toString() {

        return this.getData().toString() + "  ";

    }

}

static class ArrayList<T> {

    Node<T> head, tail;

    int len;

    public ArrayList() {

        this.head = null;

        this.tail = null;

        this.len = 0;

    }

    int size() {

        return len;

    }

    boolean isEmpty() {

        return len == 0;

    }

    int indexOf(T data) {

        if (isEmpty()) {

            throw new ArrayIndexOutOfBoundsException();

        }

        Node<T> temp = head;

        int index = 0, i = 0;

        while (temp != null) {

            if (temp.getData() == data) {

                index = i;

            }

            i++;

            temp = temp.getNext();

        }

        return index;

    }

    void add(T data) {

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {

            head = newNode;

            tail = newNode;

            len++;

        } else {

            tail.setNext(newNode);

            tail = newNode;

            len++;

        }

    }

    void see() {

        if (isEmpty()) {

            throw new ArrayIndexOutOfBoundsException();

        }

        Node<T> temp = head;

        while (temp != null) {

            out.print(temp.getData().toString() + " ");
            out.flush();

            temp = temp.getNext();

        }

        out.println();
        out.flush();

    }

    void inserFirst(T data) {

        Node<T> newNode = new Node<>(data);

        Node<T> temp = head;

        if (isEmpty()) {

            head = newNode;
            tail = newNode;

            len++;

        } else {

            newNode.setNext(temp);

            head = newNode;

            len++;

        }

    }

    T get(int index) {

        if (isEmpty() || index >= len) {

            throw new ArrayIndexOutOfBoundsException();

        }

        Node<T> temp = head;

        if (index == 0) {

            return temp.getData();

        }

        int i = 0;

        T data = null;

        while (temp != null) {

            if (i == index) {

                data = temp.getData();

            }

            i++;

            temp = temp.getNext();

        }

        return data;

    }

    void addAt(T data, int index) {

        if (index >= len) {

            throw new ArrayIndexOutOfBoundsException();

        }

        Node<T> newNode = new Node<>(data);

        int i = 0;

        Node<T> temp = head;

        while (temp.next != null) {

            if (i == index) {

                newNode.setNext(temp.next);

                temp.next = newNode;

            }

            i++;

            temp = temp.getNext();

        }

        //    temp.setNext(temp);
        len++;

    }

    T popFront() {

        if (isEmpty()) {

            throw new ArrayIndexOutOfBoundsException();

        }

        T data = head.getData();

        if (head == tail) {

            head = null;
            tail = null;

        } else {

            head = head.getNext();

        }

        len--;

        return data;

    }

    void removeAt(int index) {

        if (index >= len) {

            throw new ArrayIndexOutOfBoundsException();

        }

        if (index == 0) {

            this.popFront();

            return;

        }

        Node<T> temp = head;

        int i = 0;

        Node<T> n = new Node<>();

        while (temp != null) {

            if (i == index) {

                n.next = temp.next;

                temp.next = n;

                break;

            }

            i++;

            n = temp;

            temp = temp.getNext();

        }

        tail = n;

        --len;

    }

    void clearAll() {

        this.head = null;
        this.tail = null;

    }

}

static long gcd(long a, long b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
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

static class Node1<T> {

    T data;

    Node1 next;

    public Node1(T data) {
        this.data = data;

        this.next = null;

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

static class Stack<T> {

    int len;

    Node1<T> node;

    public Stack() {

        len = 0;

        node = null;

    }

    boolean isEmpty() {

        return len == 0;

    }

    int size() {

        return len;

    }

    void push(T data) {

        Node1<T> temp = new Node1<>(data);

        temp.setNext(this.node);

        node = temp;

        len++;

    }

    T top() {

        if (isEmpty()) {

            throw new ArrayIndexOutOfBoundsException();

        }

        return this.node.getData();

    }

    T pop() {

        if (isEmpty()) {

            throw new ArrayIndexOutOfBoundsException();

        }

        T data = this.node.getData();

        this.node = this.node.getNext();

        len--;

        return data;

    }

}

static class Scanner {

    BufferedReader in;
    StringTokenizer st;

    public Scanner() {

        in = new BufferedReader(new InputStreamReader(System.in));

    }

    String next() throws IOException {

        while (st == null || !st.hasMoreElements()) {

            st = new StringTokenizer(in.readLine());

        }

        return st.nextToken();

    }

    int nextInt() throws IOException {

        return Integer.parseInt(next());

    }

    long nextLong() throws IOException {

        return Long.parseLong(next());

    }

    String nextLine() throws IOException {

        return in.readLine();

    }

    char nextChar() throws IOException {

        return next().charAt(0);

    }

    double nextDouble() throws IOException {

        return Double.parseDouble(next());

    }

    float nextFloat() throws IOException {

        return Float.parseFloat(next());

    }

    boolean nextBoolean() throws IOException {

        return Boolean.parseBoolean(next());

    }

    void close() throws IOException {

        in.close();

    }

}

}
/*

1
6
100000000 100000054 200000000
500000003 500000034 500000000
999999906 1000000000 600000000
100000000 500000034 100000000
500000003 1000000000 400000000
100000000 1000000000 300000000

*/
/* 

1
6
3 6 10
5 7 3
1 4 4
5 9 11
1 8 3
2 6 4

*/