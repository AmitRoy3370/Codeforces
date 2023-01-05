
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Codeforces_Round_842_Div_2 {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(System.out);

    static StringBuilder ans = new StringBuilder();

    static int testCases, n, k, count = 0, d;

    static char x[], y[];

    static long a[], b[], a1[];

    static int c[];

    static long N, K;

    static int m;

    static long A[][];

    static char mat[][];

    static char ch;

    static long height, mod = (long) (Math.pow(10, 9) + 7L);

    static void buildQ(int i, Map<Long, Integer> map, long p[], long partner[]) {

        if (i >= n) {

            return;

        }

        if (!map.containsKey(a[i])) {

            p[i] = partner[(int) a[i]];

            map.put(a[i], map.getOrDefault(a[i], 0) + 1);

        } else {

            p[i] = a[i];

        }

        buildQ(i + 1, map, p, partner);

    }

    static void buildP(int i, Map<Long, Integer> map, long p[], long partner[]) {

        if (i >= n) {

            return;

        }

        if (!map.containsKey(a[i])) {

            p[i] = a[i];

            map.put(a[i], map.getOrDefault(a[i], 0) + 1);

        } else {

            p[i] = partner[(int) a[i]];

        }

        buildP(i + 1, map, p, partner);

    }

    static void C(int i, long counter[]) {

        if (i >= n) {

            return;

        }

        counter[(int) a[i]]++;

        C(i + 1, counter);

    }

    static boolean C(int i, ArrayList1<Integer> two, ArrayList1<Integer> zero, long counter[], long partner[]) {

        if (i > n) {

            return true;

        }

        if (counter[i] == 1) {

            partner[i] = i;

        } else if (counter[i] == 2) {

            two.add(i);

        } else if (counter[i] == 0) {

            zero.add(i);

        } else {

            return false;

        }

        return C(i + 1, two, zero, counter, partner);

    }

    static void C(int t) {

        long counter[] = new long[n + 1];

        C(0, counter);

        for (long i : counter) {

            if (i > 2) {

                ans.append("NO");

                if (t != testCases) {

                    ans.append("\n");

                }

                return;

            }

        }

        long partner[] = new long[n + 1];

        boolean ok = true;

        ArrayList1<Integer> two = new ArrayList1<>();
        ArrayList1<Integer> zero = new ArrayList1<>();

        ok = C(1, two, zero, counter, partner);

        if (ok) {

            long Two[] = new long[two.size()];
            long Zero[] = new long[zero.size()];

            int index = 0;

            while (!two.isEmpty()) {

                Two[index++] = two.get(0);

                two.popFront();

            }

            index = 0;

            while (!zero.isEmpty()) {

                Zero[index++] = zero.get(0);

                zero.popFront();

            }

            sort(Two, 0, Two.length - 1);
            sort(Zero, 0, Zero.length - 1);

            //printArray(Two);
            //printArray(Zero);
            //printArray(partner);
            int m = Zero.length;

            for (int i = 0; i < m; ++i) {

                if (i < Two.length && i < Zero.length && Two[i] < Zero[i]) {

                    ok = false;

                    break;

                } else {

                    if (Two[i] < partner.length) {

                        partner[(int) Two[i]] = Zero[i];

                        //System.out.println(partner[(int) Two[i]]);
                    }

                }

            }

        }

        //printArray(partner);
        if (ok) {

            long p[] = new long[n];

            long q[] = new long[n];

            ans.append("YES").append("\n");

            Map<Long, Integer> map = new HashMap<>();

            buildP(0, map, p, partner);

            /*for(long i : map.keySet()) {
                
                System.out.println(i + " " + map.get(i));
                
            }*/
            map = new HashMap<>();

            buildQ(0, map, q, partner);

            StringBuilder sb = new StringBuilder();

            for (long i : p) {

                /*if (i == 0L) {

                    sb.append(1).append(" ");
                    continue;

                }*/
                sb.append(i).append(" ");

            }

            ans.append(sb.toString().trim()).append("\n");

            sb = new StringBuilder();

            for (long i : q) {

                /*if (i == 0) {

                    sb.append(1).append(" ");

                    continue;

                }*/
                sb.append(i).append(" ");

            }

            ans.append(sb.toString().trim());

        } else {

            ans.append("NO");

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    static int getVal(int i, long val, int sequence) {

        if (i >= n) {

            return sequence;

        }

        if (a[i] == val) {

            ++val;
            ++sequence;

        }

        return getVal(i + 1, val, sequence);

    }

    static void B(int t) {

        long b[] = new long[n];

        for (int i = 0; i < n; ++i) {

            b[i] = a[i];

        }

        sort(b, 0, n - 1);

        boolean sorted = true;

        for (int i = 0; i < n; ++i) {

            if (b[i] != a[i]) {

                sorted = false;
                break;

            }

        }

        if (sorted) {

            ans.append(0);

        } else {

            int sequence = 0;

            long val = 1L;

            sequence = getVal(0, val, sequence);

            long final_ans = (long) Math.ceil((double) (n - sequence) / (double) k);

            ans.append(final_ans);

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    static void A(int t) {

        ans.append(--K);

        if (t != testCases) {

            ans.append("\n");

        }

    }

    public static void main(String[] Amit) throws IOException {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            /*K = in.nextLong();

            A(t + 1);*/
 /*n = in.nextInt();
            k = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextLong();

            }

            B(t + 1);*/
            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; ++i) {

                a[i] = in.nextLong();

            }

            C(t + 1);

        }

        out.print(ans.toString());
        out.flush();

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

        sum += a[i];

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

    static class element implements Comparable<element> {

        long element;

        int index;

        public element(long element, int index) {

            this.element = element;
            this.index = index;

        }

        @Override
        public int compareTo(element e) {

            return Long.compare(this.element, e.element);

        }

    }

    static class pair implements Comparable<pair> {

        int value;
        int index;

        public pair(int value, int index) {

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

            }

            value *= value;

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

    static int lower_bound(long a[], long value) {

        int n = a.length;

        int l = 0, r = n - 1;

        while (r > l) {

            int mid = (l + r) / 2;

            if (a[mid] >= value) {

                r = mid;

            } else {

                l = mid + 1;

            }

        }

        if (n > l && a[l] < value) {
            ++l;
        }

        return l;

    }

    static long gcd(long a, long b) {

        if (b == 0) {

            return a;

        }

        return gcd(b, a % b);

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

        String nextLine() throws IOException {

            return in.readLine();

        }

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

}
