
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class G_Practice {

    //static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);

    static StringBuilder ans = new StringBuilder();

    static int testCases, n, k, count = 0;

    static char x[], y[];

    static long a[], b[];

    static char ch;

    static void solve(int t) {

        int practice_day = 0;

        while ((int) pow(2L, practice_day) <= n - 1) {

            ++practice_day;

        }

        //System.out.println(practice_day);
        ans.append(practice_day).append("\n");

        //System.out.println(practice_day);
        int comparator;

        while (practice_day-- > 0) {

            int team_member_count = 0;

            comparator = (int) pow(2L, practice_day);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; ++i) {

                if ((i & comparator) != 0) {

                    ++team_member_count;

                    sb.append(i + 1).append(" ");

                }

            }

            //System.out.print(team_member_count + " ");
            //System.out.println(sb.toString());
            ans.append(team_member_count).append(" ");

            ans.append(sb).append("\n");

        }

        if (t != testCases) {

            ans.append("\n");

        }

    }

    public static void main(String[] Priya) throws IOException {

        testCases = 1;

        for (int t = 0; t < testCases; ++t) {

            File input = new File("input.txt");

            Scanner file = new Scanner(input);

            while (file.hasNextLine()) {

                n = Integer.parseInt(file.nextLine().trim());

                break;

            }

            solve(t + 1);

        }

        //in.close();
        //out.print(ans.toString());
        //out.flush();
        File output = new File("output.txt");

        try ( FileWriter fw = new FileWriter(output)) {

            fw.write(ans.toString());

            fw.flush();
        }

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

                return -1;

            } else if (this.value < p.value) {

                return 1;

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

        int n = a.length;

        for (int i = 0; i < n / 2; ++i) {

            swap(a, i, n - i - 1);

        }

    }

    static long max(long a[], int i, int n, long max) {

        if (i > n) {

            return max;

        }

        max = Math.max(a[i], max);

        return max(a, i + 1, n, max);

    }

    static long min(long a[], int i, int n, long max) {

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

            return len == 0;

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

}
/*

1
10
10 3 2 1 9 8 7 6 5 4



 */
