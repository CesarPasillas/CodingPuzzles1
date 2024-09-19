package levelone;

import java.util.Arrays;

/**
 * Created for the FacebookCodingPuzzles project.
 * A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing guidelines
 * require that every diner be seated such that K seats to their left and K seats to their right (or all the remaining
 * seats to that side if there are fewer than K) remain empty.
 *
 * There are currently M diners seated at the table, the ith of whom is in seat Si. No two diners are sitting in the
 * same seat, and the social distancing guidelines are satisfied.
 *
 * Determine the maximum number of additional diners who can potentially sit at the table without social distancing
 * guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the
 * additional diners will cooperate to maximize how many of them can sit down.
 *
 * Please take care to write a solution which runs within the time limit.
 *
 * @author Cesar "Aran" pasillas
 */
public class TheCafeteria {

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S){

        Arrays.sort(S);

        long extraSpace = 0; //How many extra space do we have? 0
        long firstOpenSeat = 1; //What are the first Open seat? the first one
        long openSeat = 0; //Number of open seats until de moment = 0


        for (long takenSeat : S){

          openSeat = takenSeat - K - firstOpenSeat;

          //If the openSeat is greater than 0, it means that exist some empty spaces
          if (openSeat > 0){
            extraSpace += Math.ceil(openSeat / (K + 1.0)); //It verified if there are seats before.
          }
          firstOpenSeat = takenSeat + K + 1;

        }

        openSeat = N + 1 - firstOpenSeat;

        /*long[] result = Arrays.stream(S)
                .boxed()
                .reduce(new long[]{0, 1}, (acc, takenSeat) -> {
                    long openSeat = takenSeat - K - acc[1];
                    if (openSeat > 0) {
                        acc[0] += Math.ceil(openSeat / (K + 1.0));
                    }
                    acc[1] = takenSeat + K + 1;
                    return acc;
                }, (a, b) -> a);

        long extraSpace = result[0];
        long firstOpenSeat = result[1];
        long openSeat = N + 1 - firstOpenSeat;*/

        //System.out.println(extraSpace);

        if (openSeat > 0){
            extraSpace += Math.ceil(openSeat / (K + 1.0));
        }

        return extraSpace;
    }

    /**
     *
     * @param N Seats
     * @param K Empty Seats that must be empty
     * @param M Number of seated diners
     * @param S positions where the diners are seated
     * @return maximum number if additional diners who potentially sit at the table without social distance guidelines
     * being violated.
     */
    public long getMaxAdditionalDinersCountTwo(long N, long K, int M, long[] S){
        // Sort the existing diners' positions because we will start from the first occupied position.
        Arrays.sort(S);

        long additionalDiners = 0;

        // Calculate the gap before the first diner, if there are one. We will get 0 if there are any possible sits.
        long firstGap = S[0] - 1;
        additionalDiners += Math.max(0, (firstGap - K) / (K + 1)); //The number 1 is added as the new seat.

        // Calculate the gaps between consecutive diners
        for (int i = 1; i < S.length; i++) {
            long gap = S[i] - S[i - 1] - 1;
            additionalDiners += Math.max(0, (gap - 2 * K) / (K + 1));
        }

        // Calculate the gap after the last diner
        long lastGap = N - S[S.length - 1];
        additionalDiners += Math.max(0, (lastGap - K) / (K + 1));

        System.out.println("Maximum additional diners: " + additionalDiners);

        return additionalDiners;
    }

}
