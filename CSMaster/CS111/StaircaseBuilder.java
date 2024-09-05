/*
 * Write your program inside the main method to build
 * a staicase in a 2D array of characters according
 * to the assignment description
 *
 * To compile:
 *        javac StaircaseBuilder.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class StaircaseBuilder 
{

    public static void main(String[] args) 
    {
        int d = Integer.parseInt(args[0]);
        int tot = Integer.parseInt(args[1]);
        char[][] strc = new char[d][d];

        for (int i = 0; i < d; i++) 
        {
            for (int j = 0; j < d; j++) 
            {
                strc[i][j] = ' ';
            }
        }

        for (int row = d - 1; row >= 0 && tot > 0; row--) 
        {
            int bRow = Math.min(d - row, tot);
            for (int col = d - bRow; col < d && tot > 0; col++) 
            {
                strc[row][col] = 'X';
                tot--;
            }
        }

        for (int i = 0; i < d; i++) 
        {
            for (int j = 0; j < d; j++) 
            {
                System.out.print(strc[i][j]);
            }
            System.out.println();
        }

        System.out.println("Bricks left: " + tot);
    }
}

