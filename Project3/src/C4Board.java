
public class C4Board implements C4BoardIntf{

	private int[][] BoardState;
	
	public C4Board(){
		BoardState = new int[ROWS][COLS];
	}
	
	public void addPlayerMarker(int player, int r, int c) {
		
		BoardState[r][c] = player;
	}
	
	public void resetBoard() {
		BoardState = new int[ROWS][COLS];
	}	

	
	public boolean hasPlayer1Marker(int r, int c) {
		int player = BoardState[r][c];
		return (player == 1);
	}

	
	public boolean hasPlayer2Marker(int r, int c) {
		int player = BoardState[r][c];
		return (player == 2);
	}

	
	public int[] hasWon() {
		// TODO Auto-generated method stub
		return null;
	}



}
