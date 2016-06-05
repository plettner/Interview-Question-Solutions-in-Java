package fizzbuzz;

public class FizzBuzz {

	private static String FIZZ = "Fizz";
	private static String BUZZ = "Buzz";

	public static void main(String[] args) {
		for (int count = 1; count <= 100; count++) {
			if (count % 3 == 0) {
				System.out.print(FizzBuzz.FIZZ);
			}
			if (count % 5 == 0) {
				System.out.print(FizzBuzz.BUZZ);
			}
			if (count % 3 != 0 && count % 5 != 0) {
				System.out.print(String.valueOf(count));
			}
			System.out.println();
		}
	}
}
