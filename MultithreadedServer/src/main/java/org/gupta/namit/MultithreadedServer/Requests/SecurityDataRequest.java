package org.gupta.namit.MultithreadedServer.Requests;

import java.util.List;

public class SecurityDataRequest {

	private String RequestName;
	private List<String> Symbol;
	private List<String> ISIN;	

	public String getRequestName() {
		return RequestName;
	}
	public void setRequestName(String requestName) {
		RequestName = requestName;
	}
	public List<String> getSymbol() {
		return Symbol;
	}
	public void setSymbol(List<String> symbol) {
		Symbol = symbol;
	}
	public List<String> getISIN() {
		return ISIN;
	}
	public void setISIN(List<String> iSIN) {
		ISIN = iSIN;
	}
	
	public void ValidateClientInputs() throws Exception
	{
		if(Symbol.isEmpty() && ISIN.isEmpty())
			throw new Exception("Empty values in user input.");
	}
}
