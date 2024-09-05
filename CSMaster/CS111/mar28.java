public class mar28 
{
    public static void main(String[] args)
    {
        System.out.println(bunny(15));
        System.out.println(fib(8));
    }

    public static int bunny(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        else 
        {
            return 2 + (bunny(n-1));
        }
    }
    public static int fib(int n)
    {
        if(n == 0)
        {
            return 0;
        }
        else if (n <= 1)
        {
            return 1;
        }
        else 
        {
            return fib(n-2) + fib(n-1);
        }
    }
}
