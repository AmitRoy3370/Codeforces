
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class Codeforces_Round_986_Div_2 {

    static Scanner in = new Scanner(System.in);

    static OutputWriter out = new OutputWriter(System.out);

    static StringBuilder ans = new StringBuilder();

    static int timer = 0, testCases, f, n, x_, y_, k, w, h, a11, b1, g, m, r, q, a_, b_, c_;

    static char x[], y[], z[][], _A[][], _B[][];

    static long a[], b[], c[], suffix[], prefix[], A[][], B[][], d[];

    static double time[], distance[], quries[];

    static int p[], trie[], u[], v[];

    static String s1[];

    static long seive[], factorial[], L[], R[];

    static long N = 10000010, K, M, sum = 0L, G, a1, ak, X, Y, C, l_, t_, P, R_, N_, X1, Y1, Z;

    static long xs, ys, xt, yt;

    static char mat[][];

    static long H, mod = (998244353L);

    static char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static int dir[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    static void E(int t) {

        if (t != testCases) {

            ans.append("\n");

        }

    }

    static void C(int t) {

        prefix = new long[n + 1];

        for (int i = 1; i <= n; ++i) {

            prefix[i] = prefix[i - 1] + a[i];

        }

        ArrayList1<Integer> indexesFront = new ArrayList1<>();

        sum = 0L;

        for (int i = 1; i <= n; ++i) {

            sum += a[i];

            if (sum >= K) {

                indexesFront.add(i);
                sum = 0L;

            }

        }

        ArrayList1<Integer> indexesBack = new ArrayList1<>();

        sum = 0L;

        for (int i = n; i >= 1; --i) {

            sum += a[i];

            if (sum >= K) {

                indexesBack.add(i);
                sum = 0L;

            }

        }

        if (indexesFront.size() < m) {

            ans.append("-1");

        } else {

            sum = 0L;

            b = new long[indexesFront.size()];

            int indexes = 0;

            while (!indexesFront.isEmpty()) {

                b[indexes++] = indexesFront.get(0);

                indexesFront.popFront();

            }

            c = new long[indexesBack.size()];

            indexes = 0;

            while (!indexesBack.isEmpty()) {

                c[indexes++] = indexesBack.get(0);

                indexesBack.popFront();

            }

            for (int i = 0; i <= m; ++i) {

                long subAns = 0L;

                int left = 0, right = n + 1;

                int rem = m - i;

                if (i > 0) {

                    left = (int) b[i - 1];

                }

                if (rem > 0) {

                    right = (int) c[rem - 1];

                }

                ++left;
                --right;

                if (right >= left) {

                    subAns = prefix[right] - prefix[left - 1];

                }

                sum = Math.max(sum, subAns);

            }

            ans.append(sum);

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    static void B(int t) {

        if (N == 1) {

            ans.append(K == 0 ? 0 : "1");

        } else if (M == 1 && K == 0) {

            ans.append("0");

        } else if (M == 0) {

            if (K >= N) {

                ans.append(N);

            } else if (K >= N - 2) {

                ans.append(N - 1);

            } else {

                ans.append("-1");

            }

        } else {

            if (K >= N) {

                ans.append(N);

            } else {

                long value = (N - 1L - K + M) / M;

                sum = N - value;

                sum = Math.max(sum, 0L);

                ans.append(sum);

            }

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    static void A(int t) {

        int xAxis = 0, yAxis = 0, count = 0;

        while (true) {

            ++count;

            for (char i : x) {

                switch (i) {
                    case 'N' ->
                        ++yAxis;
                    case 'E' ->
                        ++xAxis;
                    case 'S' ->
                        --yAxis;
                    case 'W' ->
                        --xAxis;
                    default -> {
                    }
                }

                if (xAxis == m && yAxis == k) {

                    break;

                }

            }

            if (count == 1000 || (xAxis == m && yAxis == k)) {

                break;

            }

        }

        if (xAxis == m && yAxis == k) {

            ans.append("YES");

        } else {

            ans.append("NO");

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    public static void main(String[] Amit) throws IOException {

        testCases = in.nextInt();
        //testCases = 1;

        //b = new long[200004];
        for (int t = 0; t < testCases; ++t) {

            E_input();
            E(t + 1);

        }

        out.print(ans.toString());
        out.flush();

    }

    private static void A_input() throws IOException {

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        x = in.next().toCharArray();

    }

    private static void B_input() throws IOException {

        N = in.nextLong();
        M = in.nextLong();
        K = in.nextLong();

    }

    private static void C_input() throws IOException {

        n = in.nextInt();
        m = in.nextInt();
        K = in.nextLong();

        a = new long[n + 1];

        for (int i = 1; i <= n; ++i) {

            a[i] = in.nextLong();

        }

    }

    private static void C1_input() throws IOException {

    }

    private static void C2_input() throws IOException {

    }

    private static void D_input() throws IOException {

        n = in.nextInt();
        m = in.nextInt();

        s1 = new String[n];

        for (int i = 0; i < n; ++i) {

            s1[i] = in.next();

        }

    }

    private static void D1_input() throws IOException {

        N = in.nextLong();

        K = in.nextLong();

    }

    private static void D2_input() throws IOException {

        N = in.nextLong();
        K = in.nextLong();

    }

    private static void E_input() throws IOException {

        n = in.nextInt();

        u = new int[n - 1];
        v = new int[n - 1];

        for (int i = 0; i < n - 1; ++i) {

            u[i] = in.nextInt();
            v[i] = in.nextInt();

        }

    }

    static void F_input() throws IOException {

        n = in.nextInt();

        m = in.nextInt();

        u = new int[m];
        v = new int[m];

        for (int i = 0; i < m; ++i) {

            u[i] = in.nextInt() - 1;
            v[i] = in.nextInt() - 1;

        }

    }

    static void G_input() {

        n = in.nextInt();

        a = new long[n];

        for (int i = 0; i != n; ++i) {

            a[i] = in.nextLong();

        }

    }

    private static long xnor(long x, long y) {
        // x should be larger  
        if (x < y) {
            // swapping x and y;  
            long temp = x;
            x = y;
            y = temp;
        }

        if (x == 0 && y == 0) {
            return 1L;
        }

        // for last bit of x  
        long x_rem = 0L;

        // for the last bit of y  
        long y_rem = 0L;

        // counter for c bit  
        // and set bit in xnorn  
        long c = 0;

        // to make new xnor number  
        long xnorn = 0;

        // for set bits in new xnor number  
        while (true) {
            // get last bit of x  
            x_rem = x & 1;

            // get the last bit of y  
            y_rem = y & 1;

            // Checking if the current two bits are the same  
            if (x_rem == y_rem) {
                xnorn |= (1 << c);
            }

            // counter for c bit  
            c++;
            x = x >> 1;
            y = y >> 1;
            if (x < 1) {
                break;
            }
        }
        return xnorn;
    }

    private static class Pair_ implements Comparable<Pair_> {

        long u, v;

        public Pair_(long u, long v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Pair_ p) {

            if (this.u > p.u) {

                return 1;

            } else if (this.u < p.u) {

                return -1;

            } else if (this.u == p.u) {

                if (this.v > p.v) {

                    return 1;

                } else if (this.v < p.v) {

                    return -1;

                } else {

                    return 0;

                }

            }

            return 0;

        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + (int) (this.u ^ (this.u >>> 32));
            hash = 11 * hash + (int) (this.v ^ (this.v >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair_ other = (Pair_) obj;
            if (this.u != other.u) {
                return false;
            }
            return this.v == other.v;
        }

    }

    private static class Element implements Comparable<Element> {

        long first, second;

        public Element(long first, long second) {
            this.first = first;
            this.second = second;
        }

        public Element(long first) {

            this.first = first;

        }

        @Override
        public int compareTo(Element element) {

            if (this.first > element.first) {

                return -1;

            } else if (this.first < element.first) {

                return 1;

            } else if (this.first == element.first) {

                return 0;

            }

            return 0;

        }

    }

    private static class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private double distance(Point p) {

            return Math.sqrt(Math.pow(Math.abs(this.x - p.x), 2L) + Math.pow(Math.abs(this.y - p.y), 2L));

        }

    }

    static void print(long a[]) {

        for (long i : a) {

            System.out.print(i + " ");

        }

        System.out.println("");

    }

    static void print(int a[]) {

        for (int i : a) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

    static void factorial() {

        int N = (2 * (int) (1e5)) + 1;

        factorial = new long[N];

        --N;

        factorial[0] = 1L;

        for (int i = 1; i <= N; ++i) {

            factorial[i] = factorial[i - 1] * i;

            factorial[i] %= mod;

        }

    }

    static void copy(int i, long a[], long b[]) {

        if (i >= a.length) {

            return;

        }

        a[i] = b[i];

        copy(i + 1, a, b);

    }

    static void seive() {

        seive = new long[10000001];

        int n = 10000001;

        for (int i = 1; i < n; ++i) {

            seive[i] = i;

        }

        for (int i = 2; i * i <= n; ++i) {

            if (seive[i] == i) {

                for (int j = i * i; j < n; j += i) {

                    seive[j] = i;

                }

            }

        }

    }

    static void copy(int i, long b[]) {

        if (i > n) {

            return;

        }

        b[i] = a[i - 1];

        copy(i + 1, b);

    }

    static void reverse(char x[]) {

        int n = x.length;

        for (int i = 0; i < n / 2; ++i) {

            char temp = x[i];
            x[i] = x[n - i - 1];
            x[n - i - 1] = temp;

        }

    }

    static void reverse(long a[], int l, int r) {

        while (l < r) {

            swap(a, l, r);

            ++l;
            --r;

        }

    }

    static boolean equal(long a, long b) {

        return String.valueOf(a).equalsIgnoreCase(String.valueOf(b));

    }

    static int mod(String num, int a) {

        int res = 0;

        for (int i = 0; i < num.length(); i++) {

            res = (res * 10 + (int) num.charAt(i) - '0') % a;

        }

        return res;
    }

    static long mod(String num, long a) {

        long res = 0L;

        for (int i = 0; i < num.length(); i++) {

            res = (res * 10 + (long) num.charAt(i) - '0') % a;

        }

        return res;
    }

    static long mul(long a[], int i, long mul) {

        if (i >= a.length) {

            return mul;

        }

        mul *= a[i];

        return mul(a, i + 1, mul);

    }

    static long sum(long a[], int i, long sum) {

        if (i >= a.length) {

            return sum;

        }

        sum = (a[i] + sum);

        //sum %= mod;
        return sum(a, i + 1, sum);

    }

    static long max(long a[], int n, int i, long max) {

        if (i >= n) {

            return max;

        }

        max = Math.max(a[i], max);

        return max(a, n, i + 1, max);

    }

    static long min(long a[], int i, int n, long min) {

        if (i >= n) {

            return min;

        }

        min = Math.min(min, a[i]);

        return min(a, i + 1, n, min);

    }

    static int min_index(long a[], int n, int i, long min, int min_index) {

        if (i >= n) {

            return min_index;

        }

        if (a[i] == min) {

            min_index = i;

        }

        return min_index(a, n, i + 1, min, min_index);

    }

    static class pair implements Comparable<pair> {

        long value;
        int index;

        public pair(long value, int index) {

            this.value = value;
            this.index = index;

        }

        @Override
        public int compareTo(pair p) {

            if (this.value > p.value) {

                return 1;

            } else if (this.value < p.value) {

                return -1;

            }

            return 0;

        }

    }

    static long pow(long value, long power) {

        long pow_value = 1L;

        while (power > 0L) {

            if (power % 2L == 1L) {

                pow_value *= value;

                pow_value %= mod;

            }

            value *= value;

            value %= mod;
            power /= 2L;

        }

        return pow_value;

    }

    static int upper_bound(long arr[], int N, long X) {
        int mid;

        int low = 0;
        int high = N;

        while (low < high) {

            mid = low + (high - low) / 2;

            if (X >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (low < N && arr[low] <= X) {
            low++;
        }

        return low;
    }

    static int upper_bound(double arr[], int N, double X) {
        int mid;

        int low = 0;
        int high = N;

        while (low < high) {

            mid = low + (high - low) / 2;

            if (X >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (low < N && arr[low] <= X) {
            low++;
        }

        return low;
    }

    static int lower_bound(long a[], long value) {

        int n = a.length;

        int l = 0, r = n - 1;

        int index = -1;

        while (r >= l) {

            int mid = (l + r) / 2;

            if (a[mid] > value) {

                r = mid - 1;

            } else {

                l = mid + 1;

                index = mid;

            }

        }

        return index;

    }

    static int lower_bound(double a[], double value) {

        int n = a.length;

        int l = 0, r = n - 1;

        int index = 0;

        while (r > l) {

            int mid = (l + r) / 2;

            if (a[mid] > value) {

                r = mid - 1;

            } else {

                l = mid + 1;
                index = mid;

            }

        }

        return index;

    }

    static long gcd(long a, long b) {

        if (b == 0L) {

            return a;

        }

        return gcd(b, a % b);

    }

    static long lcm(long a, long b) {

        long gcd = gcd(a, b);

        long lcm = (a * b) / gcd;

        return lcm;

    }

    static class Binary_Index_Tree {

        int len;

        long element[];

        int index[];

        public Binary_Index_Tree(int len) {

            element = new long[len + 1];
            index = new int[len + 2];
            this.len = len;

        }

        void add(int index, long value) {

            for (; index <= len; index += (index & -index)) {

                element[index] += value;

            }

        }

        long query(int index) {

            long sum = 0L;

            for (; index > 0; index -= (index & -index)) {

                sum += element[index];

            }

            return sum;

        }

        int get(int index) {

            if (this.index[index] == index) {

                return index;

            } else {

                return this.index[index] = get(this.index[index]);

            }

        }

    }

    static int search(long a[], long x, int last) {

        int i = 0, j = last;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (a[mid] == x) {
                return mid;
            }

            if (a[mid] < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;

    }

    static void swap(long a[], int i, int j) {

        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    static void reverse(long a[]) {

        int len = a.length;

        for (int i = 0; i < len / 2; ++i) {

            swap(a, i, len - i - 1);

        }

    }

    static long max_element(long a[], int i, int n, long max) {

        if (i > n) {

            return max;

        }

        max = Math.max(a[i], max);

        return max(a, i + 1, n, max);

    }

    static long min_element(long a[], int i, int n, long max) {

        if (i > n) {

            return max;

        }

        max = Math.min(a[i], max);

        return max(a, i + 1, n, max);

    }

    static void printArray(long a[]) {

        for (long i : a) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

    static boolean isSmaller(String str1, String str2) {

        int n1 = str1.length(), n2 = str2.length();

        if (n1 < n2) {
            return true;
        }
        if (n2 < n1) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return true;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    static String sub(String str1, String str2) {

        if (isSmaller(str1, str2)) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        String str = "";

        int n1 = str1.length(), n2 = str2.length();
        int diff = n1 - n2;

        int carry = 0;

        for (int i = n2 - 1; i >= 0; i--) {

            int sub
                    = (((int) str1.charAt(i + diff) - (int) '0')
                    - ((int) str2.charAt(i) - (int) '0')
                    - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else {
                carry = 0;
            }

            str += String.valueOf(sub);
        }

        for (int i = n1 - n2 - 1; i >= 0; i--) {
            if (str1.charAt(i) == '0' && carry > 0) {
                str += "9";
                continue;
            }
            int sub = (((int) str1.charAt(i) - (int) '0')
                    - carry);
            if (i > 0 || sub > 0) {
                str += String.valueOf(sub);
            }
            carry = 0;
        }

        return new StringBuilder(str).reverse().toString();
    }

    static String sum(String str1, String str2) {

        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        String str = "";

        int n1 = str1.length(), n2 = str2.length();
        int diff = n2 - n1;

        int carry = 0;

        for (int i = n1 - 1; i >= 0; i--) {

            int sum = ((int) (str1.charAt(i) - '0')
                    + (int) (str2.charAt(i + diff) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = ((int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0) {
            str += (char) (carry + '0');
        }

        return new StringBuilder(str).reverse().toString();
    }

    static long detect_sum(int i, long a[], long sum) {

        if (i >= a.length) {

            return sum;

        }

        return detect_sum(i + 1, a, sum + a[i]);

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

    static class ArrayList1<T> {

        Node<T> head, tail;

        int len;

        public ArrayList1() {

            this.head = null;

            this.tail = null;

            this.len = 0;

        }

        int size() {

            return len;

        }

        boolean isEmpty() {

            return len == 0 || head == null || tail == null;

        }

        int indexOf(T data) {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            Node<T> temp = head;

            int index = -1, i = 0;

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

                System.out.print(temp.getData().toString() + " ");
                //out.flush();

                temp = temp.getNext();

            }

            System.out.println();
            //out.flush();

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

            if (index == 0) {

                return head.getData();

            }

            Node<T> temp = head;

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

        void popFront() {

            if (isEmpty()) {

                //return;
                throw new ArrayIndexOutOfBoundsException();

            }

            if (head == tail) {

                head = null;
                tail = null;

            } else {

                head = head.getNext();

            }

            len--;

        }

        void removeAt(int index) {

            if (index >= len || index < 0) {

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

    static void merge(double a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        double L[] = new double[n1];

        double R[] = new double[n2];

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

    static void sort(double a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

    static class OutputWriter {

        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

    static class Scanner {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public Scanner(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public String nextLine() {
            return readLine();
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextInt();
            }
            return array;
        }

        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = nextLong();
            }
            return array;
        }

        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) {
                array[i] = array[i - 1] + nextInt();
            }
            return array;
        }

    }

}