
import java.util.Scanner;

public class C_Interesting_Sequence {

    static Scanner in = new Scanner(System.in);

    static long n, x;

    static int testCases;

    /*
	
	testCases3:
	
	20: 1	0	1	0	0
	16: 1	0	0	0	0
	
	20: 1	0	1	0	0
	21: 1	0	1	0	1
	-----------------------
	20: 1	0	1	0	0
	22: 1	0	1	1	0
	-----------------------
	20: 1	0	1	0	0
	23: 1	0	1	1	1
	------------------------
	20: 1	0	1	0	0
	24: 1	1	0	0	0
	------------------------
	16:	1	0	0	0	0
	
	so, here m = 24
	
     */
    static long low_bit(long v) {

        return (v & -v);

    }

    static void C() {

        if (x > n) {

            System.out.println(-1);
            return;

        }

        if (n == x) {

            System.out.println(n);
            return;

        }

        long m = n;

        while (m != x) {

            if ((m & x) != x) {

                System.out.println(-1);
                return;

            }

            n += low_bit(n);
            m &= n;

        }

        System.out.println(n);

    }

    static void solve() {

        if (x > n) {

            System.out.println(-1);

            return;

        }

        if (n == x) {

            System.out.println(n);

            return;

        }

        if (x == 0L) {

            long ans = (long) (Math.log(n) / Math.log(2));

            ++ans;
			
			ans = 1L << ans;

            System.out.println(ans);

            return;

        }

        int bitn[] = new int[66];
        int bitx[] = new int[66];

        char a[] = new StringBuilder().append(Long.toBinaryString(n)).reverse().toString().toCharArray();

        int len = a.length;

        for (int i = 0; i < len; ++i) {

            bitn[i] = (a[i] - '0');

        }

        a = new StringBuilder().append(Long.toBinaryString(x)).reverse().toString().toCharArray();

        len = a.length;

        for (int i = 0; i < len; ++i) {

            bitx[i] = (a[i] - '0');

        }

        //print(bitn);
        //print(bitx);
        len = 66;

        for (int i = 0; i < len; ++i) {

            if (bitx[i] == 1 && bitn[i] == 0) {

                System.out.println(-1);
                return;

            }

        }

        boolean gotOne = false;

        for (int bit = 0; bit < len; ++bit) {

            if (bitx[bit] == 0) {

                if (bitn[bit] == 1) {

                    if (gotOne) {

                        System.out.println(-1);
                        //System.out.println("here");
                        return;

                    }

                }

            } else {

                //System.out.println("entry here for bit " + bit);
                gotOne = true;

            }

        }

        long last_bit = 0L, num = 0L, ans = n;

        for (int bit = 0; bit < len; ++bit) {

            if (bitx[bit] == 1) {

                if (last_bit == (1L << bit)) {

                    System.out.println(-1);
                    //System.out.println("here");
                    return;

                }

                n += (last_bit - num);
                ans = n;
                break;

            }

            if (bitn[bit] == 1) {

                num += (1L << bit);
                last_bit = (1L << (bit + 1));

            }

        }

        System.out.println(ans);

    }

    public static void main(String[] priya) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            n = in.nextLong();

            x = in.nextLong();

            C();
            //solve();

        }

    }

    static void print(int a[]) {

        for (int i = 0; i < 5; ++i) {

            System.out.print(a[i] + " ");

        }

        System.out.println();

    }

}
