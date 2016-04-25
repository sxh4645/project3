
import java.io.IOException;

public interface ModelListener {

	public void playerJoin(int player) throws IOException;
	
	public void setName(int player, String name) throws IOException;
	
	public void setTurn(int player) throws IOException;
}

