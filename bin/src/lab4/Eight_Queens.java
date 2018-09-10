package lab4;

public class Eight_Queens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = new int [8][8];
		solve(0,board,8);
		for(int i = 0; i < 8; i++){
			for( int j = 0; j < 8; j++){
				if(board[i][j]==1){
					System.out.print("Q ");
				}
				else{
					System.out.print("X ");
				}
			}
			System.out.println();
		}
	}

	static boolean solve(int row, int[][] board, int N) {
		if(row >= N){
			return true;
		}
		for(int col = 0; col < N; col++) {
			if(isValid(board, row, col, N)){
				board[row][col] = 1;
				if(!solve(row+1, board, N)) {
					board[row][col] = 0;
				} 
				else{
					return true;
				}	
			}
		}
		return false;
	}

	static boolean isValid(int[][] board, int x, int y, int N) {
		int i, j;
		for(i = 0; i < x; i++)
			if(board[i][y]==1){
				return false;
			}
		i = x - 1;
		j = y - 1;
		while(i >=0 && j >= 0)
			if(board[i--][j--]==1){
				return false;
			}
		i = x - 1;
		j = y + 1;
		while(i >= 0 &&  j < N){
			if(board[i--][j++]==1){
				return false;
			}
		}
		return true;
	}
}

