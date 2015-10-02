/*
 * Check if three sides form a triangle.
 * 
 * Solution: 
 * Triangle Inequality Theorem:
 * 1) a + b > c
 * 2) a + c > b
 * 3) b + c > a
 */
public static boolean isTriangle(int a, int b, int c){
	return (a + b > c) && (a + c > b) && (b + c > a);
}