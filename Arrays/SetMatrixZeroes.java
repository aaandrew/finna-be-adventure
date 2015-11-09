/* Leetcode/CTCI
 * Given a mxn matrix, if an element is 0, set its entire row/col to 0 (in place).
 */

// Good solution, check leetcode for better one
// Time: O(n*m)
// Space: O(1)
public void setZeroes(int[][] matrix) {
	boolean firstRowZero = false;
	boolean firstColZero = false;

	// Set first row/col to zero to mark deleted row/col
	for(int i=0; i<matrix.length; i++){
		for(int j=0; j<matrix[0].length; j++){
			if(matrix[i][j] == 0){
				// Mark first row/col need to be zero
				if(i == 0) firstRowZero = true;
				if(j == 0) firstColZero = true;
				matrix[0][j] = 0;
				matrix[i][0] = 0;
			}
		}
	}

        // Set marked rows to zero
	for(int i=1; i<matrix.length; i++){
		if(matrix[i][0] == 0){
			setZeroesRow(matrix, i);
		}
	}

	// Set marked cols to zero
	for(int i=1; i<matrix[0].length; i++){
		if(matrix[0][i] == 0){
			setZeroesCol(matrix, i);
		}
	}


	// Set zeroes for first row/col
	if(firstRowZero){
		setZeroesRow(matrix, 0);
	}

	if(firstColZero){
		setZeroesCol(matrix,0);
	}

}

private static void setZeroesCol(int[][] matrix, int start){
	for(int i=0; i<matrix.length; i++){
		matrix[i][start] = 0;
	}
}

private static void setZeroesRow(int[][] matrix, int start){
	for(int i=0; i<matrix[0].length; i++){
		matrix[start][i] = 0;
	}
}