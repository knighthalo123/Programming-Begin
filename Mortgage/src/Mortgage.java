

public class Mortgage {
	private double loanAmount,lengthLoan,interestRate,monthlyPayment;
	
	
	public static void main(String[]args){
		Mortgage m = new Mortgage();
		m.getInfo();
		m.getMonthly();
		m.printPayments();
	}
	
	public void getInfo(){
		String ask = "Enter the amount of the loan ";
		loanAmount = Prompt.getDouble(ask,1000,5000000);
		ask = "Enter the number of years for the loan ";
		lengthLoan = Prompt.getDouble(ask,1,50);
		ask = "Enter the interest rate of the loan ";
		interestRate = Prompt.getDouble(ask,1,20);
		System.out.println();
	}
	
	public void getMonthly(){
		interestRate = interestRate / 100;
		String ask = "Enter the monthly payment for the loan ";
		double p = loanAmount;
		double k = interestRate/12;
		double n = lengthLoan * 12;
		double c = Math.pow( (1.0 + k),n);
		
		
		double a = (p * k * c) / (c - 1.0);
		
		System.out.printf("Your minimum monthly payment is : %.2f\n",a);
		a = Double.parseDouble(String.format("%.2f",a));
		monthlyPayment = Prompt.getDouble(ask,a,loanAmount);
	}
	
	public void printPayments(){
		double total = 0.0;
		double oldLoan = 0.0;
		double newInterest;
		int month = 1;
		System.out.println("Month Principal      Interest     Payment  New Principal");
		
		do{
			newInterest = (interestRate / 12) * loanAmount;
			oldLoan = loanAmount;
			if((oldLoan + newInterest) < monthlyPayment){
				monthlyPayment = oldLoan+newInterest;
			}
			loanAmount = loanAmount + newInterest - monthlyPayment;
			System.out.printf("%3d  %10.2f + %10.2f - %10.2f = %-2.2f \n",month,oldLoan,newInterest,monthlyPayment,loanAmount);
			month++;
			total = total+=monthlyPayment;
		}while(loanAmount > 0);
		
		System.out.printf("\n\nTotal money paid over the life of the loan : %.2f",total);
	}
}
