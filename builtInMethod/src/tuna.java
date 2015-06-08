
public class tuna {
	private String name;
	private oranges birthday;
	
	public tuna (String theName, oranges birthdayDate){
		name = theName;
		birthday = birthdayDate;
	}
	
	public String toString(){
		return String.format("My name is %s, my birthday is %s", name, birthday);
	}
}
