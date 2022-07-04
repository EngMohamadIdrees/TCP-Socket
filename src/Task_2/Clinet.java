import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clinet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip;
		try {
			ip = InetAddress.getByName("localhost");
			Socket clientSocket= new Socket(ip,5109);
			Scanner inpuut=new Scanner(System.in);
			DataInputStream input=new DataInputStream(clientSocket.getInputStream());
			DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());
			String conn= input.readUTF();
			System.out.println("Server :"+conn);
			System.out.println();
			while(true)
			{
				String Ask=input.readUTF();
				System.out.println("Server :"+Ask);
				System.out.println();
				
				String request=inpuut.nextLine();
				output.writeUTF(request);
				
				String []arrstr=request.split(",");
				
				
				if(request.equalsIgnoreCase("close"))
				{
					clientSocket.close();
					System.out.print("Connection is closed ");
					System.out.println();
				}
				else if(!request.equalsIgnoreCase("close")&&arrstr[0].matches("\\d"))
				{

						String replay=input.readUTF();
						System.out.print("Server : "+replay);
						System.out.println();
					
						String request2=inpuut.nextLine();
						output.writeUTF(request2);
						
						
						if(request2.equalsIgnoreCase("1"))
						{
							String order=input.readUTF();
							System.out.println("Server : "+order);
							
						}
						else
						{
							String order=input.readUTF();
							System.out.print("Server : "+order);
							System.out.println();
							
						}
					  
				}
				else
				{
					String replay2=input.readUTF();
					System.out.print("Server : "+replay2);
					System.out.println();
				}
					
			}
		} catch (UnknownHostException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

	}

}
