package org.gupta.namit.MultithreadedServer.Controller.Backend;

import org.gupta.namit.MultithreadedServer.Requests.SecurityDataRequest;
import org.gupta.namit.MultithreadedServer.Response.SecurityDataResponse;

public class BusinessLogic {
	
	public BusinessLogic(){}
	
	public SecurityDataResponse GetSecurityData(SecurityDataRequest securityData)
	{
		SecurityDataResponse securityDataResponse = new SecurityDataResponse();
		
		if (securityData.getSymbol().size() != securityData.getISIN().size())
			throw new IllegalArgumentException("Length of symbol and ISIN vectors mismatch");
		
		for (String security : securityData.getSymbol())
		{
			Double DummyPrice = 89.3232157;
			securityDataResponse.getSecurityPrices().put(security, DummyPrice);
		    // Not using ISIN. 
		}
		
		return securityDataResponse;
	}
}
