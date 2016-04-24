
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectFour {

	public static void main(String[] args) throws Exception {
		
		//java ConnectFour localhost 5678 Blake
		if ( args.length != 3){
			System.err.println("Invalid arguments");
			System.exit(1);
		}
		
		//Variables
		String host 	= args[0];
		int port 		= Integer.parseInt(args[1]);
		String player 	= args[2];
		
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind (new InetSocketAddress (host, port));
				
        Socket socket = serverSocket.accept();
        
        ModelProxy proxy = new ModelProxy(socket);

	}

}

