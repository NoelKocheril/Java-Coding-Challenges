package c_295;
/*
Pascal's triangle is a triangular array of integers constructed with the following formula:

    The first row consists of the number 1.
    For each subsequent row, each element is the sum of the numbers directly above it, on either side.

For example, here are the first few rows:

    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Given an input k, return the kth row of Pascal's triangle.
*/

import java.util.Scanner;
public class c_295 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Enter Row Number: ");
		int r = in.nextInt();
		in.close();
		for(int i = 0; i <= r; i++) {
			System.out.printf("%d ", nCk(r, i));
		}
		System.out.println();
	}

	/**
	 * nCk - N choose K 
	 * @param row - Row Number
	 * @param pos - Position within Row 
	 * 
	 * <pre>
	 * 
	 *     n!
	 * -----------
	 * k! * (n-k)!
	 * 
	 * </pre>
	 */
	public static long nCk(int n, int k) {
		long res = 1;
		// Position can not be greater than row number
		if(k > n - k)
			k = n - k;
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}
}
