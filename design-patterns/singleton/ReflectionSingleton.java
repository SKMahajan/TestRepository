package com.dec.designpatterns.singleton;

public class ReflectionSingleton {

	private static ReflectionSingleton instance;
	
	private ReflectionSingleton() {
		if(instance != null) {
			throw new RuntimeException("Exception while creating singleton instance");
		}
	}
	
	public static synchronized ReflectionSingleton getInstance() {
		if(instance == null) {
			synchronized (ReflectionSingleton.class) {
				instance = new ReflectionSingleton();
			}
		}
		return instance;
	}
}
