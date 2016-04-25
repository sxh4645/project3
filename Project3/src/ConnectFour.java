
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectFour {

	public static void main(String[] args) throws Exception {
		
		//java ConnectFour localhost 5678 Blake
		if ( args.length != 3){
			System.err.println("Invalid argument length");
			System.exit(1);
		}
		
		//Variables
		String host 	= args[0];
		int port 		= Integer.parseInt(args[1]);
		String name 	= args[2];
		
        //Create Socket to Server
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress (host, port));
				        
        ModelProxy proxy = new ModelProxy(socket);
        C4UI view = new C4UI(null, name);
        
        view.setViewListener(proxy);
        proxy.setModelListener(view);
        proxy.joinGame(name);
	}

}