/* Leetcode
 * Given a nxn matrix, rotate it by 90 degrees (clockwise).
 */
public void rotate(int[][] matrix) {
	for(int i=0; i<matrix.length/2; i++){
		for(int j=i; j<matrix[i].length-i-1; j++){
			swap(matrix, i, j);
		}
	}
}

public void swap(int[][] matrix, int i, int j){
	int topLeft = matrix[i][j];
	int rowOffset = matrix.length-1-i;
	int colOffset = matrix.length-1-j;
	
	matrix[i][j] = matrix[colOffset][i];
	matrix[colOffset][i] = matrix[rowOffset][colOffset];
	matrix[rowOffset][colOffset] = matrix[j][rowOffset];
	matrix[j][rowOffset] = topLeft;
}