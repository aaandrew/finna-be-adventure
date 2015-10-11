/*
 * You are given two positive ints M and N. Count pairs (A,B) where
	1 <= A <= M
	1 <= B <= N
	(A^1/3 + b^1/3)^3 is an int
	cubeNumbers(M,n) return count of pairs that satisfy the property

	Examples:
	1) m = 1, n = 1
	(1,1)
	output : 1

	2) m = 1, n = 8
	(1,1)
	(1,8)
	output: 2

	3) m = 1, n= 27
	output: 3
	(1,1)
	(1,8)
	(1,27)

	4) m = 8, n = 27
	output: 6
	(1,1)
	(1,8)
	(1,27)
	(8,1)
	(8,8)
	(8,27)
 */
public static int cubeNumbers(int M, int N) {
	int A = 1;
	int B = 1;
	int count = 0;
	int cubeA = 1;
	int cubeB = 1;
	while (cubeA <= M) {
		B = 1;
		cubeB = 1;
		while (cubeB <= N) {
			count++;
			B++;
			cubeB = B*B*B;
		}
		A++;
        cubeA = A*A*A;

	}
	return count;
}