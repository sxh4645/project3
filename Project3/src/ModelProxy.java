
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ModelProxy implements ViewListener{

	// Hidden data members.
    private Socket socket;
    private Scanner in;
    private PrintStream out;
    private ModelListener modelListener;
    
    // Exported constructors.
    /**
    * Construct a new model proxy.
    * ... 
    */
    public ModelProxy(Socket socket) throws IOException{
        this.socket = socket;
		out = new PrintStream(socket.getOutputStream());
		in 	= new Scanner(socket.getInputStream());
    }
    
    // Exported operations.
    /**
    * Set the model listener object for this model proxy.
    * ... 
    */
    public void setModelListener(ModelListener modelListener){
        this.modelListener = modelListener;
        new ReaderThread() .start();
    }

    /**
    * Start the password cracking process.
    * ... 
    */
    public void joinGame(String name)throws IOException
    {
    	System.out.println("Starting Game");
	    out.print("join " + name + System.lineSeparator());
	    out.flush();
    }
    
	public void newGame() throws IOException {
		out.print("clear" + System.lineSeparator());
		out.flush();
	}

	public void action(int player, int column) throws IOException {
		out.print("add " + player + " " + column);
		out.flush();		
	}    
    

// Hidden helper classes.
    /**
     * Class ReaderThread receives messages from the network,
     * decodes them, and invokes the proper methods to process them.
     * ... 
     */
    private class ReaderThread extends Thread
    {
        public void run() {
            try {        	
                while (true) {
                	
                	String read = in.nextLine();
                	String[] data = read.split(" ");
                	                	
                	System.out.println(read); //DEBUGGING - REMOVE ME
                	
                	
                    switch (data[0]) {
                        // number <p>
                        case "number":
                        	modelListener.playerJoin(Integer.parseInt(data[1]));
                            break;
                        // name <p> <n>
                        case "name":
                        	modelListener.setName(Integer.parseInt(data[1]), data[2]);
                        	break;
                        //turn <p>
                        case "turn":
                        	modelListener.setTurn(Integer.parseInt(data[1]));
                        	break;
                        //add <p> <r> <c>
                        case "add":
                        	break;
                        case "clear":
                        	break;
                        default:
                            System.err.println ("Bad message");
                            break;
                        }
                    }
                }
           catch (Exception exc) 
           {
           }
            finally {
                try {
                    socket.close();
                    }
                catch (IOException exc) {
                    }
                }
            }
        }
    }