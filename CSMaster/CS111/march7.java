public class march7 
{
    public static void main(String[] args) 
    {
        System.out.println(area(2,1));
        System.out.println(cel(4));
        System.out.println(speed(8,10));
        System.out.println(dia(6));

    }

public static double area(double base,double height)
{
    return ((base*height)/2);
}
public static double cel(double celcius)
{
    return (celcius*(9/5))+32;
}
public static double speed(double distance,double time)
{
    return distance/time;
}
public static double dia(double radius)
{
    return 2*radius;
}

}
