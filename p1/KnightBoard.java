

import java.util.Arrays;

public class KnightBoard {

	public int board[][];
	int pos = 2;
	int n, count;
	public final int[] col = {1, 2, 2, 1, -1, -2, -2, -1};
	public final int[] row = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public KnightBoard(int n, int x, int y, int strat) {
		this.n = n;
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = -1;
			}
		}
		
		if(isValid(x, y, board)) {
			board[x][y] = 1;
			System.out.println("Position (" + x + ", " + y + ") is step: 1");
		}
		
		if(strat == 0) {
			if(!KnightBoardBasic(board, x, y, pos)) {
				System.out.println("The total number of moves is: " + count);
				System.out.println("Solution does not exist");
			}else {
				System.out.println("The total number of moves is: " + count);
				print(board);
			}
		}else if(strat == 1) {
			if(!KnightBoardHeurOne(board, x, y, pos)){
				System.out.println("The total number of moves is: " + count);
				System.out.println("Solution does not exist");
			}else {
				System.out.println("The total number of moves is: " + count);
				print(board);
			}
		}else if(strat == 2) {
			if(!KnightBoardHeurTwo(board, x, y, pos)) {
				System.out.println("The total number of moves is: " + count);
				System.out.println("Solution does not exist");
			}else {
				System.out.println("The total number of moves is: " + count);
				print(board);
			}
		}
	}
	
	private boolean KnightBoardBasic(int board[][], int x, int y, int pos) {
		if(pos > n*n) {
			return true;
		}
				
		for(int k=0; k<8; k++) {
			int nextX = x+row[k];
			int nextY = y+col[k];
			
			
			if(isValid(nextX, nextY, board)) {
				count++;
				board[nextX][nextY] = pos;
				
				if(KnightBoardBasic(board, nextX, nextY, pos+1)){
					return true;
				}
				board[nextX][nextY] = -1;
			}
		}
		return false;
	}
	
	private boolean KnightBoardHeurOne(int board[][], int x, int y, int pos) {
		int holdX=0, holdY=0, nextX, nextY, c, min_deg = n+1, min_deg_idx = -1;
		
		if(pos > n*n) {
			return true;
		}
		
		for(int k=0; k<8; k++) {
			System.out.println("Checking pos: " + k);
			holdX = x+row[k];
			holdY = y+col[k];
			
			if(isValid(holdX, holdY, board) && (c = getAdj(board, holdX, holdY)) < min_deg) {
				min_deg_idx = k;
				min_deg = c;
				System.out.println(k + " " + c);
			}
		}
		
		System.out.println("Found min deg at: " + min_deg_idx);
	
		if(min_deg_idx == -1) {
			System.out.println("Min deg idx == -1");
			return false;
		}
				
		nextX = x+row[min_deg_idx];
		nextY = y+col[min_deg_idx];
		
		System.out.println("nextX: " + nextX + "\nnextY: " + nextY);
		
		count++;

		board[nextX][nextY] = pos;
				
		if(KnightBoardHeurOne(board, nextX, nextY, pos+1)){
			return true;
		}
			
		board[nextX][nextY] = -1;
		
		return false;
	}

	private boolean KnightBoardHeurTwo(int board[][], int x, int y, int pos) {
		return true;
	}
	
	private boolean isValid(int x, int y, int[][] board) {
		if(x<0 || x>=n || y<0 || y>=n || board[x][y]!=-1) {
			return false;
		}
		return true;
	}
	
	private int getAdj(int board[][], int x, int y) {
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(isValid(x+row[i], y+col[i], board)) {
				count++;
			}
		}
		return count;
	}

	private static void print(int[][] board) {
		for(var r: board) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println();
	}
}
