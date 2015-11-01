/* Leetcode
 * Print matrix in spiral order
 */

public List<Integer> spiralOrder(int[][] matrix){
	List<Integer> list = new ArrayList<Integer>();
	if(matrix == null || matrix.length == 0) return list;
	int startRow = 0, endRow = matrix.length-1, startCol = 0, endCol = matrix[0].length-1;
	while(startRow <= endRow && startCol <= endCol){
		// left to right
		for(int i=startCol; i<=endCol; i++){
			list.add(matrix[startRow][i]);
		}
		startRow++;
		// top to bottom
		for(int i=startRow; i<=endRow; i++){
			list.add(matrix[i][endCol]);
		}
		endCol--;
		// right to left
		if(startRow <= endRow){
			for(int i=endCol; i>=startCol; i--){
				list.add(matrix[endRow][i]);
			}
			endRow--;
		}
		// bottom to top
		if(startCol <= endCol){
			for(int i=endRow; i>=startRow; i--){
				list.add(matrix[i][startCol]);
			}
			startCol++;
		}
	}

	return list; 
}