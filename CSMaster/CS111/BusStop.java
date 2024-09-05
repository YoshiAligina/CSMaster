/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class BusStop {

    public static void main(String[] args)
     {

        int busOrder = -1;
        char serenaBus = args[args.length - 1].charAt(0);


        for (int i = 0; i < args.length-1; i++) 
        {
            char curr = args[i].charAt(0);

            if (curr == serenaBus) 
            {
                busOrder = i + 1; 
                break;
            }
        }

        System.out.println(busOrder); 
    }
}

