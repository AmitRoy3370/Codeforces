
import java.util.Scanner;

public class D_Yet_Another_Monster_Killing_Problem {

    static Scanner in = new Scanner(System.in);

    static int testCases, monster_quantity, heros_quantity;

    static long heros_power[], monster_power[];

    static int monster_can_kill_one_time[];

    /*
    
    bruteforces way :
    
    just sort the monster powers in asending order
    then check with the biggest heros power with the monster power that which monster can 
    kill which monster at the min day.
    this will take O(nm) complexity
    
    optimization way:
    
    our main target is to minimize the number of day, so we need to consult that at every time 
    we use the maximum heros power against the monster. so to ensure that we can store the heos
    according to the number of monster he can kill at a time and for the same quantity we will consider 
    the biggest power monster for that day. Then we just check the list and till which list it can kill
    ther monster and for any absent list we can declare it as failure.
    
     */
    static void solve() {

        long dp[] = new long[monster_quantity + 1];

        // store the maximum power monster can kill for particular day
        for (int i = 0; i < heros_quantity; ++i) {

            dp[monster_can_kill_one_time[i] - 1] = Math.max(dp[monster_can_kill_one_time[i] - 1], heros_power[i]);

        }

        // determine the max among all of them
        for (int i = monster_quantity - 2; i >= 0; --i) {

            dp[i] = Math.max(dp[i], dp[i + 1]);

        }

        //print(dp);
        int day_passes = 0;

        for (int i = 0, j = 0; i < monster_quantity; i = j) {

            j = i; // store the initial index of the iteration

            long max_monster_power = monster_power[i];

            while (j < monster_quantity && (max_monster_power = Math.max(max_monster_power, monster_power[j])) <= dp[j - i]) {

                ++j;

            }

            if (i == j) { // if no value is changed

                System.out.println("-1");
                return;

            }

            ++day_passes;

        }

        System.out.println(day_passes);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 0; t < testCases; ++t) {

            monster_quantity = in.nextInt();

            monster_power = new long[monster_quantity];

            for (int i = 0; i < monster_quantity; ++i) {

                monster_power[i] = in.nextLong();

            }

            heros_quantity = in.nextInt();

            heros_power = new long[heros_quantity];
            monster_can_kill_one_time = new int[heros_quantity];

            for (int i = 0; i < heros_quantity; ++i) {

                heros_power[i] = in.nextLong();
                monster_can_kill_one_time[i] = in.nextInt();

            }

            solve();

        }

    }

    static void print(long dp[]) {

        for (long i : dp) {

            System.out.print(i + " ");

        }

        System.out.println();

    }

}

/*

2
6
2 3 11 14 1 8
2
3 2
100 1
5
3 5 100 2 3
2
30 5
90 1


 */
