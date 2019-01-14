import java.util.Scanner;

public class Reg_Number {
	private final static Scanner in = new Scanner(System.in);
	private static int max;
	public static void main(String[] args) {		
		int _temp;
		boolean f;
		System.out.print("Enter a Maximum Number (Inclusive): ");
		do {
			max = in.nextInt();
		} while (max > 0);
		in.close();
		System.out.printf("The Regular Numbers upto %d are: %n", max);
		System.out.println(1);
		for(int i = 2; i <= max; i++) {
			_temp = i;
			do {
				f = false;
				if(_temp % 2 == 0) {
					f = true;
					_temp /= 2;
				} else if (_temp % 3 == 0) {
					f = true;
					_temp /= 3;					
				} else if (_temp % 5 == 0) {
					f = true;
					_temp /= 5;
				}
				if(_temp == 1 && f) {
					System.out.println(i);
					break;
				}
			} while (f);
		}
	}
}