
/* 2660. Determine the Winner of a Bowling Game

        You are given two 0-indexed integer arrays player1 and player2, that represent the number of pins that player 1 and player 2 hit in a bowling game, respectively.

        The bowling game consists of n turns, and the number of pins in each turn is exactly 10.

        Assume a player hit xi pins in the ith turn. The value of the ith turn for the player is:

        2xi if the player hit 10 pins in any of the previous two turns.
        Otherwise, It is xi.
        The score of the player is the sum of the values of their n turns.

        Return

        ->1 if the score of player 1 is more than the score of player 2,
        ->2 if the score of player 2 is more than the score of player 1, and
        ->0 in case of a draw.
        Example 1:

        Input: player1 = [4,10,7,9], player2 = [6,5,2,3]
        Output: 1
        Explanation: The score of player1 is 4 + 10 + 2*7 + 2*9 = 46.
        The score of player2 is 6 + 5 + 2 + 3 = 16.
        Score of player1 is more than the score of player2, so, player1 is the winner, and the answer is 1.
        Example 2:

        Input: player1 = [3,5,7,6], player2 = [8,10,10,2]
        Output: 2
        Explanation: The score of player1 is 3 + 5 + 7 + 6 = 21.
        The score of player2 is 8 + 10 + 2*10 + 2*2 = 42.
        Score of player2 is more than the score of player1, so, player2 is the winner, and the answer is 2.
        Example 3:

        Input: player1 = [2,3], player2 = [4,1]
        Output: 0
        Explanation: The score of player1 is 2 + 3 = 5
        The score of player2 is 4 + 1 = 5
        The score of player1 equals to the score of player2, so, there is a draw, and the answer is 0.



        Constraints:

        n == player1.length == player2.length
        1 <= n <= 1000
        0 <= player1[i], player2[i] <= 10
*/

public class BowlingGame {

    public static int score(int[] v) {
        int ret = 0;
        for (int i = 0; i < v.length; i++) {
            if (i > 0 && v[i - 1] == 10 || i > 1 && v[i - 2] == 10) {
                ret += v[i] * 2;
            } else {
                ret += v[i];
            }
        }
        return ret;
    }

    public static int isWinner(int[] player1, int[] player2) {
        int v = score(player1);
        int v2 = score(player2);
        if (v > v2) {
            return 1;
        } else if (v < v2) {
            return 2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] player1a = {4,10,7,9};
        int[] player2a = {6,5,2,3};
        System.out.println(isWinner(player1a, player2a)); // Output should be 1

        int[] player1b = {3,5,7,6};
        int[] player2b = {8,10,10,2};
        System.out.println(isWinner(player1b, player2b)); // Output should be 2

        int[] player1c = {2,3};
        int[] player2c = {4,1};
        System.out.println(isWinner(player1c, player2c)); // Output should be 0
        int[] player1d = {2,8,2,10,6};
        int[] player2d = {10,7,4,5,9};
        System.out.println(isWinner(player1d, player2d)); // Output should be 2
        int[] player1e = {7,8,8,5,2};
        int[] player2e = {10,1,4,2,6};
        System.out.println(isWinner(player1e, player2e)); // Output should be 2
    }
}
