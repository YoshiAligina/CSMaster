public class feb29 
{
    public static void main(String[] args)
    {
        int n = 0;
        int random = 1 + (int)(Math.random()*100);


        while (n!=random)
        {
            StdOut.println("Guess a number between 1-100 ");
            n = StdIn.readInt();
            if(n == random)
            {
                System.out.println("You got it!");
            }
            else if(n> 100 || n <0)
            {
                System.out.println("You can't guess that.");
            }
     }
    System.out.println("Right!");
    }
}
