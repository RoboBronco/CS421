
public class KnightBoard {

	private int board[][];
	int pos = 0;
	int n;
	public final int[] row = {2, 1, -1, -2, -2, -1,  1,  2};
	public final int[] col = {1, 2,  2,  1, -1, -2, -2, -1};
	
	public KnightBoard(int n, int x, int y, int strat) {
		this.n = n;
		board = new int[n][n];
		if(isValid(x, y)) {
			board[x][y] = pos;
		}
		
		if(strat == 0) {
			KnightBoardBasic(board, x, y, pos);
		}
	}
	
	public void KnightBoardBasic(int board[][], int x, int y, int pos) {
		
		for(int k=0; k<8; k++) {
			int nextX = x+row[k];
			int nextY = y+col[y];
			
			if(isValid(nextX, nextY) && board[nextX][nextY]==0) {
				KnightBoardBasic(board, nextX, nextY, pos+1);
			}
		}

	}

	private boolean isValid(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=n) {
			return false;
		}
		return true;
	}
	
}
