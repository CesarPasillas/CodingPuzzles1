package levelone;

/**
 * Created for the FacebookCodingPuzzles project.
 * Test Class for the "The Cafeteria" problem
 *
 * @author Cesar Aran Pasillas
 */
public class TheCafeteriaTestDrive {

    public static void main(String[] args) {
        TheCafeteria cafeteria = new TheCafeteria();
        long n = 10;
        long k = 1;
        int m = 2;
        long[] s = {2, 6};
        cafeteria.getMaxAdditionalDinersCountTwo(n, k, m, s);
    }
}
