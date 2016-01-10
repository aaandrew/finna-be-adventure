/* Leetcode
 *
 */

// Input format: 1st (and only) line contains 81 integers. 
// First 9 represent first row, and so on.
public static void main(String[] args){
	// test
	// 963174258178325649254689731821437596496852317735961824589713462317246985642598173 = 1
	// 123456789123456789123456789123456789123456789123456789123456789123456789123456789 = 0

	Scanner scanner = new Scanner(System.in);
	// Read line
	String s = scanner.nextLine();
	// Close scanner
	scanner.close();

	// Parse board
	int[][] board = new int[9][9];
	int start = 0;
	for(int i=0; i<board.length; i++){
		int[] row = new int[9];
		for(int j=0; j<row.length; j++){
			row[j] = s.charAt(start++) - '0';
		}
		board[i] = row;
	}
	if(validSudoku(board)){
		System.out.println(1);
	}else{
		System.out.println(0);
	}
}

public static boolean validSudoku(int[][] board){
	boolean[] visited = new boolean[board.length+1];

	// Check all rows
	for(int i=0; i<board.length; i++){
		visited = new boolean[visited.length];
		for(int j=0; j<board[0].length; j++){
			if(visited[board[i][j]]) return false;
			visited[board[i][j]] = true;
		}
	}

	// Check all columns
	for(int j=0; j<board[0].length; j++){
		visited = new boolean[visited.length];
		for(int i=0; i<board.length; i++){
			if(visited[board[i][j]]) return false;
			visited[board[i][j]] = true;
		}
	}

	// Check all squares
	for(int s=0; s<board.length; s+=3){
		for(int k=0; k<board.length; k+=3){
			visited = new boolean[visited.length];
			for(int i=s; i<s+3; i++){
				for(int j=k; j<k+3; j++){
					if(visited[board[i][j]]) 
						return false;
					visited[board[i][j]] = true;
				}
			}
		}
	}
	return true;
}