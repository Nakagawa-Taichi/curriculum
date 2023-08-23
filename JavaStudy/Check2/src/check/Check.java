package check;

import constants.Constants;

public class Check {
	private void printName(String firstName, String lastName) {
		System.out.println(firstName + lastName);
	}
	public static void main(String[] args) { 
		Check check = new Check();
		String firstName = "達智";
		String lastName = "中川";
		
		Pet pet1 = new
Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);

		RobotPet pet3 = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
		
		check.printName("printNameメゾット → "+lastName,firstName);
		pet1.introduce();
		
		pet3.introduce();
	}
}
