import java.io.IOException;

public interface ViewListener
{	
	public void joinGame (String name) throws IOException;
	
	public void newGame() throws IOException;
	
	public void action(int player, int column) throws IOException;
}