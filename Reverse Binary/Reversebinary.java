import java.util.*;

public class Reversebinary {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		int newNum = 0;

		while(num != 0) {
			// If there are more bits left, double the previous value, add the modulus value, 
			// And divide the old value minus the modulus by 2.
				newNum *= 2;
				newNum += (num % 2);
				num = (num - (num % 2)) / 2;
		}

		System.out.println(newNum);
	}
}