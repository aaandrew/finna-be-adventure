/* 
 * Print diagonals of matrix
 */


// Time: O(n*m) n is rows, m is cols
// Space: O(1)
public static void printDiagonally(int[][] matrix){
  int length = matrix.length + matrix[0].length -1;
  for(int i=0; i<length; i++){
    int row = Math.min(i, matrix.length-1);
    int col = Math.max(0, i-row);
    while(row >= 0 && col < matrix[0].length){
      System.out.print(matrix[row][col] + " ");
      row--; col++;
    }
    System.out.println();
  }
}

public static void main(String[] args){
  int[][] matrix = {
    {1, 2, 3, 4, 5},
    {6, 7, 8, 9, 10},
    {11,12,13,14,15},
    {16,17,18,19,20}
  };

  /* Output
    1 
    6 2 
    11 7 3 
    16 12 8 4 
    17 13 9 5 
    18 14 10 
    19 15 
    20
  */
  printDiagonally(matrix);
}
