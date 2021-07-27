/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** helper function that returns the next number */
    public static int nextNumber(int n) {
        if (n == 1) {
            return 1;
        } else if (n%2 == 1) {
            return 3 * n + 1;
        } else {
            return n/2;
        }
    }

    /** actually calling the function in main*/
    public static void main(String[] args) {
        int n = 158;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

