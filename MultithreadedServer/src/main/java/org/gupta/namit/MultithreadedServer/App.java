package org.gupta.namit.MultithreadedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.gupta.namit.MultithreadedServer.Controller.HandleIncomingRequest;
import org.gupta.namit.MultithreadedServer.Singleton.ExecutorServiceSingleton;

public class App 
{
	final static   int          PORT_NUMBER = 8080;
	private static ServerSocket listener    = null;

	public static void main( String[] args ) 
	{	
		try 
		{
			listener = new ServerSocket(PORT_NUMBER);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			return;
		}

		try
		{
			while(true)
			{
				Socket socket = null;

				try
				{
					socket = listener.accept();
					ExecutorServiceSingleton.getInstance().submit(new HandleIncomingRequest(socket));
				}
				catch (IOException e) 
				{
					try {socket.close();} catch (IOException e1) {e1.printStackTrace();}
					e.printStackTrace();
				}
			}
		} 		
		finally
		{
			try 
			{
				listener.close();
				ExecutorServiceSingleton.getInstance().shutdownNow();
			} 
			catch (IOException e) {e.printStackTrace();}
		}
	}
}
