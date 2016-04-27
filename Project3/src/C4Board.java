
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
	
	public boolean deadGame(){
		boolean isDead = true;
		for(int c = 0; c < COLS; c++){
			for(int r = 0; r < ROWS; r++){
				if (BoardState[r][c] == 0){
					isDead = false;
				}				
			}
		}
		
		return isDead;
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
		int[] coords = null;

		coords = horizontalWinner();
		if (coords != null) { return coords; }
		coords = verticalWinner();
		if (coords != null) { return coords; }
		coords = diagonalWinner();
		if (coords != null) { return coords; }		
		
		return null;
	}

	private int[] horizontalWinner(){

		// Start With each row and check horizontal wins ONLY
		for (int r = 0; r < ROWS; r++) {

		    for (int c = 0; c < COLS - 3; c++) {
				if (BoardState[r][c] != 0 &&
		            BoardState[r][c] == BoardState[r][c+1] &&
		            BoardState[r][c] == BoardState[r][c+2] &&
		            BoardState[r][c] == BoardState[r][c+3]){
						
					int[] coords = new int[4];
					
					coords[1] = c;
					coords[0] = r;
					coords[3] = c+3;
					coords[2] = r;
					
					return coords;					
				}
		    }    
		}

		return null;
	}

	private int[] verticalWinner(){
		
		// Start With each column and check vertical wins ONLY
		for (int c = 0; c < COLS; c++) {
					    
		    for(int r = 0; r < ROWS - 3; r++){
				if (BoardState[r][c] != 0 &&
		            BoardState[r][c] == BoardState[r+1][c] &&
		            BoardState[r][c] == BoardState[r+2][c] &&
		            BoardState[r][c] == BoardState[r+3][c]){
						
					int[] coords = new int[4];
					
					coords[1] = c;
					coords[0] = r;
					coords[3] = c;
					coords[2] = r+3;
					
					return coords;						
		            
				}				
			}
		}

		return null;		
	}

	private int[] diagonalWinner(){
						
		//Top Left to Bottom Right Winner
		for (int c = 0; c < COLS - 3; c++) {
     
            for (int r = 0; r < ROWS - 3; r++) {
				if (BoardState[r][c] != 0 &&
					BoardState[r][c] == BoardState[r+1][c+1] &&
				    BoardState[r][c] == BoardState[r+2][c+2] &&
				    BoardState[r][c] == BoardState[r+3][c+3]){
						
					int[] coords = new int[4];
					
					coords[1] = c;
					coords[0] = r;
					coords[3] = c+3;
					coords[2] = r+3;
					
					return coords;
				}
            }
        }
        
        //Top Right to Bottom Left Winner
		for (int c = COLS - 1; c >= 3; c--) {
     
            for (int r = 0; r < ROWS - 3; r++) {
				if (BoardState[r][c] != 0 &&
					BoardState[r][c] == BoardState[r+1][c-1] &&
				    BoardState[r][c] == BoardState[r+2][c-2] &&
				    BoardState[r][c] == BoardState[r+3][c-3]){
						
					int[] coords = new int[4];
					
					coords[1] = c;
					coords[0] = r;
					coords[3] = c-3;
					coords[2] = r+3;
					
					return coords;
				}
            }
        }        
			
		return null;			       
	}
}
