
import java.io.IOException;

public interface ModelListener {

	public void playerJoin(int player);
	
	public void setName(int player, String name);
	
	public void setTurn(int player);

	public void addMove(int player, int r, int c);

	public void newGame();
}

