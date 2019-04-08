package com.dec.designpatterns.abstractfactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("pc ram", "pc hdd", "pc cpu"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("s ram", "s hdd", "s cpu"));
		
		System.out.println(pc);
		System.out.println(server);
	}
}
