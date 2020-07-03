
public class KnightTour {
	
	public static void main(String[] args) {
		
		int strat = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int x = Integer.parseInt(args[2]);
		int y = Integer.parseInt(args[3]);
		
		//KnightBoard.KnightBoardBasic(n, x, y, strat);
		//System.out.println(tour.board[1][1]);
		
		Kinght.startKnightTour(n, x, y);
		
		
	}

}
