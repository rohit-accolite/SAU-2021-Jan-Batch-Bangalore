public class Ques2 {
	public static void main(String args[]) {
		try {
			System.out.println(divide(25,0));
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		return;
	}
	
	private static double divide(int number_one, int number_two) throws ArithmeticException {
		if(number_two == 0) {
			throw new ArithmeticException("You cannot divide by 0");
		}
		
		return number_one/number_two;
	}
}