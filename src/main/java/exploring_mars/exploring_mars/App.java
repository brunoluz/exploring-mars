package exploring_mars.exploring_mars;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // String name = System.console().readLine();
        // System.out.println(name);
        
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String s = in.next();
        
        System.out.println(i);
        System.out.println(s);
    }
}
