package com.dec.designpatterns.singleton;

public class DeserialisedSingleton {
	private static DeserialisedSingleton instance = new DeserialisedSingleton();
	
	private DeserialisedSingleton() {}
	
	public static DeserialisedSingleton getInstance() {
		return instance;
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
