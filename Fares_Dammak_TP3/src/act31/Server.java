package act31;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	public void run() {	
			try {
				int nbrclient=1;
				 ServerSocket socketServeur = new ServerSocket(1234);
				
				System.out.println("le server attend la connexion du client !");
				while(true) {
					Socket socket = socketServeur.accept();
				
					ClientProcess client = new ClientProcess(socket,nbrclient);
					client.start(); 

					 nbrclient++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server().start(); 
	}
	public class ClientProcess extends Thread {
		Socket socket;
		int numClient;
		public ClientProcess(Socket socket, int numClient){ 
			 super(); 
			 this.socket = socket; 
			 this.numClient=numClient;
			 }
		public void run() { 
			try {
			 System.out.println("Le client numéro "+ numClient + " de ID : "+ socket.getRemoteSocketAddress()+" est connecté !");
			 PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			 pw.println("Bienvenue vous etes le client num : " + numClient);
			 
			
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		
	}

}
