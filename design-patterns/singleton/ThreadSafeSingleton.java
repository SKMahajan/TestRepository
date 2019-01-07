package com.dec.designpatterns.singleton;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	public static synchronized ThreadSafeSingleton getDoubleCheckInstance() {
		if(instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				instance= new ThreadSafeSingleton();
			}
		}
		return instance;
	}
}
