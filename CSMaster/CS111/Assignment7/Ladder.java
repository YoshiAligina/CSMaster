/**
 * Creates a ladder using recursion.
 * The ladder is built starting at the bottom and backs out
 * at the top.
 * 
 * ODD levels are denoted by |=|\n (rails/step followed by new line)
 * EVEN levels are denoted by | |\n (rails followed by new line)
 * The TOPMOST level (n = 1) is the end of the ladder: |-|\n
 * 
 * ASSUME n >= 1.
 * 
 * Compilation: javac Ladder.java
 * Execution: java Ladder
 *
 * @author Kal Pandit
 * @author Mary Buist
 */
public class Ladder {

    public static String createLadder(int n) 
    {
        String s;
        if ( n == 1)
        {
            return "|-|\n";

        }
        else if (n % 2 == 0)
        {
            s = "| |\n";
        }
        else
        {
            s = "|=|\n";
        }

        return createLadder(n-1) +s;
    }
    
    public static void main(String[] args) {
        System.out.println(createLadder(6));
        System.out.println(createLadder(5));
        System.out.println(createLadder(4));
        System.out.println(createLadder(3));
        System.out.println(createLadder(2));
        System.out.println(createLadder(1));
    }
}
