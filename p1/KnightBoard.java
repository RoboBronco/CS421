import java.util.Arrays;

public class KnightBoard {

	public int board[][];
	int pos = 0;
	int n;
	public final int[] col = {1, 2,  2,  1, -1, -2, -2, -1};
	public final int[] row = {2, 1, -1, -2, -2, -1,  1,  2};
	
	public KnightBoard(int n, int x, int y, int strat) {
		this.n = n;
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = -1;
			}
		}
		
		if(isValid(x, y, board)) {
			board[x][y] = pos;
			System.out.println("Initial position (" + x + ", " + y + ") is:" + board[x][y]);
		}
		
		if(strat == 0) {
			KnightBoardBasic(board, x, y, pos);
		}
	}
	
	public void KnightBoardBasic(int board[][], int x, int y, int pos) {
		
		board[x][y] = pos;
		System.out.println("position (" + x + ", " + y + ") is step: " + board[x][y] + "\n");
		
		if(pos >= n*n) {
			print(board);
			//board[x][y] = 0;
			return;
		}
				
		for(int k=0; k<8; k++) {
			int nextX = x+col[k];
			int nextY = y+row[y];
			
			System.out.println("Testing position (" + nextX + ", " + nextY + ")");
			if(isValid(nextX, nextY, board)) {
				pos++;
				System.out.println("Next position is: (" + nextX + ", " + nextY + ")\n");
				KnightBoardBasic(board, nextX, nextY, pos);
			}
		}
		
		System.out.println("Over 8");
		board[x][y] = -1;

	}

	private boolean isValid(int x, int y, int[][] board) {
		if(x<0 || x>=n || y<0 || y>=n || board[x][y]!=-1) {
			return false;
		}
		return true;
	}

	private static void print(int[][] board) {
		for(var r: board) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println();
	}
}
