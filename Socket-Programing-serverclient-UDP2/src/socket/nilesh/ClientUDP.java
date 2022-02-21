package socket.nilesh;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientUDP {

	public static void main(String[] args) {
		
		try {
			
			DatagramSocket ds=new DatagramSocket();
			System.out.println("client Started");
			
			//Sending msg
			InetAddress ia=InetAddress.getByName("localhost");
			String s="hay i'm client";
			byte b[]=s.getBytes();
			DatagramPacket dp=new DatagramPacket(b, b.length,ia,5344);
			ds.send(dp);
			 System.out.println("msg send to servler");
			 
			 
			 //Receiving msg
			 byte[] b1=new byte[1000];
			 DatagramPacket dp1=new DatagramPacket(b1,b1.length);
			 ds.receive(dp1);
			 String s1=new String(dp1.getData());
			 System.out.println(s1);
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
