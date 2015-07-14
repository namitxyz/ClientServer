package org.gupta.namit.MultithreadedServer.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.gupta.namit.MultithreadedServer.Controller.Backend.BusinessLogic;
import org.gupta.namit.MultithreadedServer.Requests.SecurityDataRequest;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class HandleIncomingRequest implements Runnable{

	private static final String REQUEST_NAME = "RequestName";
	private static final String SECURITY_DATA_REQUEST = "SecurityDataRequest";
	private static final String EXECUTE_TRADE = "ExecuteTrade";
	
	private Socket socket = null;
	private static Gson gson = new Gson();
	private static BusinessLogic businessLogic = new BusinessLogic();
	
	
	public HandleIncomingRequest(Socket socket)
	{
		this.socket = socket;
	}

	public void run() 
	{
		try
		{
			BufferedReader InputBuffer  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter    OutputBuffer = new PrintWriter(socket.getOutputStream(), true);

			ProcessIncomingRequest(InputBuffer, OutputBuffer);
		}
		catch(Exception e){ e.printStackTrace();}
		finally {try {socket.close();} catch (IOException e) {e.printStackTrace();}}
	}

	private void ProcessIncomingRequest(BufferedReader InputBuffer, PrintWriter OutputBuffer) throws Exception
	{
		JSONObject jsonInput = new JSONObject(InputBuffer.readLine());
		String RequestName = jsonInput.getString(REQUEST_NAME);
		
		if(RequestName.equals(SECURITY_DATA_REQUEST))
		{
			SecurityDataRequest securityData = gson.fromJson(jsonInput.toString(), SecurityDataRequest.class);
			securityData.ValidateClientInputs();
			OutputBuffer.println(gson.toJson(businessLogic.GetSecurityData(securityData)));		
		}
		else
		if(RequestName.equals(EXECUTE_TRADE))
		{
			// TODO
		}
		else
		{
			throw new IllegalArgumentException("Invalid Request :"+ RequestName);	
		}
	}
}
