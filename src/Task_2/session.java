import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java. util. Arrays;
import java.util.Collections;

public class session extends Thread {
	
	Socket clientSocket;
	public session(Socket clientSocket) {
		this.clientSocket=clientSocket;
	}
	
	@Override
	public void run() {
		Scanner inpuut = new Scanner(System.in);
		try {
		
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());
			output.writeUTF("connected");
			while(true)
			{
				output.writeUTF("Please enter the list of numbers to be arranged or 'close' to close the connection");
				
				String request=input.readUTF();
				
				String []arrstr=request.split(",");
		        
		        if(request.equalsIgnoreCase("close"))
	        	{
				clientSocket.close();
				System.out.println("Conection with this client is closed");
				System.out.println();
				break;
	        	}
		        else if(!request.equalsIgnoreCase("close")&&arrstr[0].matches("\\d"))
				{
		        		while(true)
		        		{
		        			output.writeUTF("Please choose:\r\n"
								+ "1. Ascending order.\r\n"
								+ "2. Descending order.");

		        			String request2=input.readUTF();
		        			//System.out.println("Clinet :"+request2);
		        			
		        			if(request2.equalsIgnoreCase("1"))
		        			{
									int temp;
									int size=arrstr.length;
									int [] arr=new int[size];
									for(int i=0;i<size;i++)
				        			{
				        				arr[i] = Integer.parseInt(arrstr[i]);
				        			}
									
								for(int i=0;i<arr.length;i++)
								{
									for(int j=i;j<arr.length;j++)
									{
										if(arr[i]>arr[j])
										{
											temp=arr[i];
											arr[i]=arr[j];
											arr[j]=temp;
										}
									}
								
								}

						StringBuilder stringBuilder = new StringBuilder();
						for (int i = 0; i < arr.length; i++) {
							if(i==0)
							{
								stringBuilder.append("[");
							}
						    stringBuilder.append(arr[i]);
						    if(i==(arr.length)-1)
						    {
						    	stringBuilder.append("]");
						    	break;
						    }
						    stringBuilder.append(",");
						}
						String arrS = stringBuilder.toString();
						output.writeUTF(arrS);
						break;
		        		}
		        		else if(request2.equalsIgnoreCase("2"))
		        			{
		        				int temp;
		        				int size=arrstr.length;
		        				int [] arr=new int[size];
		        				for(int i=0;i<size;i++)
			        			{
			        				arr[i] = Integer.parseInt(arrstr[i]);
			        			}
		        				for(int i=0;i<arr.length;i++)
		        				{
		        					for(int j=i;j<arr.length;j++)
		        					{
		        						if(arr[i]<arr[j])
		        						{
		        							temp=arr[i];
		        							arr[i]=arr[j];
		        							arr[j]=temp;
		        						}
		        					}
		        				}
		        				StringBuilder stringBuilder = new StringBuilder();
								for (int i = 0; i < arr.length; i++) {
									if(i==0)
									{
										stringBuilder.append("[");
									}
								    stringBuilder.append(arr[i]);
								    if(i==(arr.length)-1)
								    {
								    	stringBuilder.append("]");
								    	break;
								    }
								    stringBuilder.append(",");
								}
								String arrS = stringBuilder.toString();
								output.writeUTF(arrS);
								break;
		        			}
		        			else 
		        			{
		        				output.writeUTF("Wrong Choice please enter 1 or 2");
		        				
		        			}
					  }
		        
		    	}
		        else
				{
						output.writeUTF("Wrong Choise please enter a valid input number or 'close'");
						
				}
		}
	}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
}
