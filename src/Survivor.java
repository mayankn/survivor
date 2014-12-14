import java.util.BitSet;

/**
 *
 * Survivor
 *
 * Description:
 * 100 chairs are arranged in a circle.
 * These chairs are numbered sequentially from One to One Hundred.
 * At some point in time, the person in chair #1 will be told to leave the
 * room. The person in chair #2 will be skipped, and the person in chair #3
 * will be told to leave. Next to go is person in chair #6. In other words,
 * 1 person will be skipped initially, and then 2, 3, 4.. and so on.
 * This pattern of skipping will keep going around the circle until there is
 * only one person remaining.. the survivor.
 * Note that the chair is removed when the person leaves the room.
 *
 * Given the number of chairs, prints the chair number,
 * the survivor is sitting in.
 *
 */
public class Survivor {

    BitSet chairs;

    /**
     *
     * Driver method to test the survivor problem
     * Prints the chair number of the survivor (chair numbers begin from 1)
     * @param args command-line arguments (the program ignores them for now)
     */
    public static void main(String args[]) {
        Survivor s1 = new Survivor();
        System.out.println("Survivor is #" + s1.getSurvivor(100));
    }

    /**
     *
     * @param numChairs the number of chairs
     * @return the chair number of the survivor (chair numbers begin from 1),
     *         returns -1, if an invalid number of chairs is given
     */
    public int getSurvivor(int numChairs) {
        if (numChairs < 2) {
            return -1;
        }

        this.chairs = new BitSet(numChairs);
        // occupy all chairs initially
        this.chairs.set(0, numChairs, true);

        int skip = 0, idx = 0, survivor = 0;
        int personsRemaining = numChairs;

        // repeat until there is only 1 person remaining
        while (personsRemaining > 1) {
            // loop over each of the remaining chairs only
            for (int i = idx, count = skip; i >= 0; ) {
                // 'skip' number of chairs will be skipped
                if (count > 0)
                    count--;
                else {
                    idx = i;
                    break;
                }

                // get the next remaining chair
                i = this.chairs.nextSetBit((i + 1) % numChairs);
                if (i == -1)
                    i = this.chairs.nextSetBit(0);
            }

            // remove the next chair after performing the skipping
            this.chairs.clear(idx);
            idx = this.chairs.nextSetBit(idx);
            if (idx == -1)
                idx = this.chairs.nextSetBit(0);

            skip++;
            personsRemaining--;
            survivor = idx;
        }
        return survivor + 1;
    }
}
