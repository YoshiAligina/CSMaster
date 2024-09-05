public class febtwentytwo
{
    public static void main(String[] args)
    {
        int size = Integer.parseInt(args[0]);
        int value = Integer.parseInt(args[1]);

        int myArray[] = new int[size];
        myArray[0] = value;
    
        for(int i=1;i<size;i++)
        {
          myArray[i] = (myArray[i-1])*2;
        }
        for(int i = 1; i <size;i++)
        {
            System.out.print(myArray[i]);
            if(i != size)
            {
                System.out.print(",");
            }
        }

    }
}
