package act32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inetAddress =  InetAddress.getByName("10.27.13.196");
			InetSocketAddress inetSocketAdd = new InetSocketAddress(inetAddress,1234);
			Socket socket = new Socket();
			socket.connect(inetSocketAdd);
			System.out.println("Je suis connecte !!");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			int nb1;
			String op;
			int nb2;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Donner un nombre 1 : ");
			nb1 = scanner.nextInt();
			System.out.println("Donner un nombre 2 : ");
			nb2 = scanner.nextInt();
			do {
				System.out.println("Choisir l operateur : ");
				System.out.println("Pour + pour addition \n Pour - sustraction \n Pour *multiplication \n Pour / division \n");
				op = scanner.nextLine();
				System.out.println("+");
			}while(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/"));
			Operation opr = new Operation(nb1,nb2,op);
			oos.writeObject(opr);
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			
			System.out.println("Resultat : "+bf.readLine());
			System.out.println("Deconnexion");
			socket.close();
			scanner.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
