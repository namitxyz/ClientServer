package org.gupta.namit.MultithreadedServer.Response;

import java.util.HashMap;

public class SecurityDataResponse {
	
	HashMap<String, Double> SecurityPrices = new HashMap<String, Double>();

	public HashMap<String, Double> getSecurityPrices() {
		return SecurityPrices;
	}

	public void setSecurityPrices(HashMap<String, Double> securityPrices) {
		SecurityPrices = securityPrices;
	}
}
