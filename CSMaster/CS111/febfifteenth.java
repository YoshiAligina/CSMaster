public class febfifteenth
{
    public static void main(String[] args)
    {
        /* \
         * 1. What can we do do with a for loop that we can not do with a while loop? They are exactly the same. 
         * 2. How do you get the length of your command-line arguements? args.length
         * 3. What is the range of math.random(), )0.0-1.0. Not including 1.
         

        int age = Integer.parseInt(args[0]);
        boolean canVote = false;
         if(age<0)
         {System.out.println("You can not be younger than zero.");}
         else if(age<= 18 && age >= 0) {
            canVote = false;
            System.out.println(canVote);}
         else {
            canVote = true;
            System.out.println(canVote);}  
        
        int speed = Integer.parseInt(args[0]);
        if(speed<0){
            System.out.println("Not possible to be negative speed");
        }
        else if(speed<= 60 ){
            System.out.println("Slow down. Don't do it again.");
        }
        else if(speed> 60 && speed <= 75){
            System.out.println("Slow down. A fee of $100.00 has been administered.");
        }
        else if(speed> 75 && speed <= 90){
            System.out.println("Slow down. A fee of $200.00 has been administered.");
        }
        else {
            System.out.println("Slow down. A fee of $500.00 has been administered.");
        } */

    int n = Integer.parseInt(args[0]);
    int i = 1;

    if(n>0)
    {
        while(i<=n)
        {
            System.out.println(i);
            i++;
        }
    }
    else 
    {
        System.out.println("This num is less then 1. ");
    }

    }
}
