import java.io.File;
import java.io.PrintWriter;

public class BinarySearch
{
    public static final int NOT_FOUND = -1;
    
    /**
     * Performs the standard binary search
     * using two comparisons per level.
     * @return index where item is found, or NOT_FOUND.
     */
    public static int binarySearch( String [ ] a, String x )
    {
        int low = 0;
        int high = a.length - 1;
        int mid;
        int counter = 0;

        while( low <= high )
        {
        	counter++;
        	System.out.println("counter = " + counter);
            mid = ( low + high ) / 2;
        	System.out.println("mid = " + mid + " high = " + high + " low = " + low);
            if( a[ mid ].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[ mid ].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;
        }

        return NOT_FOUND;     // NOT_FOUND = -1
    }

    // Test program
    public static void main( String [ ] args )
    {
        String [ ] a = new String [ 17 ];
        a[0] = "at";
        a[1] = "bat";
        a[2] = "cat";
        a[3] = "dot";
        a[4] = "err";
        a[5] = "foe";
        a[6] = "get";
        a[7] = "he";
        a[8] = "me";
        a[9] = "my";
        a[10] = "or";
        a[11] = "see";
        a[12] = "so";
        a[13] = "to";
        a[14] = "we";
        a[15] = "yes";
        a[16] = "you";
        
        System.out.println(binarySearch(a,"her"));
        
    }
}  