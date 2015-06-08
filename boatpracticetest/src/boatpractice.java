
public class boatpractice {
	
	public static void main(String[]args){
		double car = 29;
		
		for(double boat = 2000; boat>1800;boat-=50){
			car = boat/car +26;
			System.out.println(car);
		}
		
		boatpractice a = new boatpractice();
		
		a.test();
	
	}
	
	public void test(){
		double car = 29;
		double boat = 2000;
		do{
			car = boat/car + 26;
			System.out.println(car);
			boat -= 50;
		}while(boat>1800);
		
		
	}
}
