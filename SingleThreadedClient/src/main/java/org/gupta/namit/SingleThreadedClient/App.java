package org.gupta.namit.SingleThreadedClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.JSONArray;
import org.json.JSONObject;

public class App 
{
	public static void main( String[] args ) throws UnknownHostException, IOException
	{
		Socket socket = new Socket("127.0.0.1", 8080);

		BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);

		JSONArray SymbolList = new JSONArray();

		SymbolList.put("GOOG:US");
		SymbolList.put("IBM:US");
		SymbolList.put("MSFT:US");

		JSONArray ISINList = new JSONArray();

		ISINList.put("123456");
		ISINList.put("5678");
		ISINList.put("8765");

		JSONObject Request = new JSONObject();
		Request.put("RequestName", "SecurityDataRequest");
		Request.put("Symbol", SymbolList);
		Request.put("ISIN", ISINList);

		System.out.println(Request.toString());
		output.println(Request.toString());

		//String data = "{\"Symbol\":[\"GOOG:US\",\"IBM:US\",\"MSFT:US\"],\"RequestName\":\"SecurityDataRequest\",\"ISIN\":[\"1234\",\"5678\",\"8765\"]}";
		//System.out.println(data);
		//output.println(data);
		
		while(true)
		{
			String inputd = input.readLine();

			if(inputd !=null)
			{
				System.out.println("Response from server :" + inputd);
				return;
			}
		}
	}
}
