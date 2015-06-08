/* What is the output of the following program? */

public class Test {

  public boolean equals( Test other ) {
    System.out.println( "Inside of Test.equals" );
    return false;
  }

  public static void main( String [] args ) {
    Object t1 = new Test();
    Object t2 = new Test();
    Test t 3 = new Test();
    Test t4 = new Test();
    Object o1 = new Object();

    int count = 0;
    System.out.println( count++ );// prints 0
    System.out.println(t1 == t2);
    t1.equals( t2 ) ;
    System.out.println( count++ );// prints 1
    System.out.println(t1.equals(t3));
    t1.equals( t3 );
    System.out.println( count++ );// prints 2
    System.out.println(t3.equals(o1));
    t3.equals( o1 );
    System.out.println( count++ );// prints 3
    System.out.println(t3.equals(t3));
    t3.equals(t3);
    System.out.println( count++ );// prints 4
    System.out.println(t3.equals(t2));
    t3.equals(t2);
  }
}