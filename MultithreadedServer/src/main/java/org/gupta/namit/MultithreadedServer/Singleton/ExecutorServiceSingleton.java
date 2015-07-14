package org.gupta.namit.MultithreadedServer.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSingleton {

	private static ExecutorService instance;
	final static int MAX_NUMBER_THREADS = 5;

	private ExecutorServiceSingleton(){}

	public static ExecutorService getInstance() 
	{
		if(instance == null) 
			instance = Executors.newFixedThreadPool(MAX_NUMBER_THREADS);

		return instance;
	}
}
