/*
 * Print a grade-school multiplication table NxN
 */
public static void multiplicationTable(int n) {
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			System.out.print(String.format("%4d", j*i));
		}
		System.out.println();
	}
}