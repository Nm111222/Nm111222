package socket.nilesh;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ServletUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DatagramSocket ds=new DatagramSocket(5344);
			System.out.println("Server Started");
			
			//Receiving data
			byte[] b=new byte[1000];
			DatagramPacket dp=new DatagramPacket(b, b.length);
			ds.receive(dp);
			String s=new String(dp.getData());
			System.out.println(s);
			
			
			//Sending data
			InetAddress ia=InetAddress.getLocalHost();
		 Scanner sc=new Scanner(System.in);
		 System.out.println("please enter data ");
		 String s1=sc.next();
		 
		 byte[] b1=s1.getBytes();
		 DatagramPacket dp1=new DatagramPacket(b1, b1.length,ia ,dp.getPort());
		 ds.send(dp1);
		 System.out.println("data send by servlet");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
