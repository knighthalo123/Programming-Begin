public class pt1
{
	int a = 2; 

	private int[] za = new int[7];
	public static void main (String [] args)
	{
		pt1 run = new pt1();
		run.test();
	}
	
	public void test(){
		if(a > 0){
			a--;
			test();
		}else{
			
		}
		System.out.println("hi");
	}
	
	
	public void problem7 ( )
	{
		System.out.println(( 74 - 47 * 3 % 11 / 7 - 72 ));
		System.out.println(( 74 - 37 * 3 % 11 / 7 - 72 ));
		
		
		System.out.println(89 + 67 / 23 - 3 % 4 * 17);
		System.out.println(89 + 67 / 23 - 3 % 4 * 19);
		
		
		System.out.println((int)5.89 * 2 - 7 % 1 + 16 / 3);
		System.out.println((int)4.89 * 2 - 7 % 1 + 16 / 3);
		
		
		System.out.println("HI" + 7 + 'a' + 2.1);
		System.out.println("NO" + 8 + 'x' + 3.1);
		System.out.println();
		System.out.println();
		System.out.println();
	}
}