
public class variableLengthArgument {
		public static void main(String[]args){
			System.out.println(average(21,24,23));
		}
		
		public static double average(double...numbers ){//... used when unknown number of arguments
			double total = 0;
			for(double x:numbers){
				total+=x;
			}
			return total/numbers.length;
			
		}
}
