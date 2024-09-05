public class april4 
{    public static void main(String[] args)
    {
    System.out.println(letterCount('h',"hello"));
    System.out.println(palindrome("hello"));
    }
    public static int letterCount(char j,String s)
    {
        int count = 0;
        for(int i=0; i < s.length(); i++) {
            if (s.charAt(i) == (j)) {         
                count++;
            }
        }
        return(count);
    }
    public static boolean palindrome (String s)
    {
        for(int i=0; i < s.length()/2; i++) {
            boolean b;
            if (s.charAt(i) != ())
             {         
                return false;
                        }
            else
            {
                b = false;
            }
        }
            return b;
    }
}

/*
a. 
1. c
2. -5
3. False
4. True
5. 2
6. 6
7. 5
8. llo
9.CS111
10. HELLO
11. hello

b. 
1. True
2. False

  */