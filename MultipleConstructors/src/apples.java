
public class apples {
	public static void main(String[]args){
		tuna object1 = new tuna();
		tuna object2 = new tuna(5);
		tuna object3 = new tuna(5,13);
		tuna object4 = new tuna(5,13,43);//looks for which constructor in tuna class
		//has 0 or 1 or 2 or 3 arguments, then uses them.
		
		System.out.printf("%s\n", object1.toMilitary());
		System.out.printf("%s\n", object2.toMilitary());
		System.out.printf("%s\n", object3.toMilitary());
		System.out.printf("%s\n", object4.toMilitary());
	}
}
