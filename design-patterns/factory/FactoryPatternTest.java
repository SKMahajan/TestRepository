package com.dec.designpatterns.factory;

public class FactoryPatternTest {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", "pc ram", "pc hdd", "pc cpu");
		Computer server = ComputerFactory.getComputer("Server", "s ram", "s hdd", "s cpu");
		
		System.out.println("PC : "+pc);
		System.out.println("Server : "+server);
	}

}
