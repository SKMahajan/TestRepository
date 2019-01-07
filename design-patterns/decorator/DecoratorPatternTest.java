package com.dec.designpatterns.decorator;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		
		Car lCar = new LuxuryCar(new BasicCar());
		lCar.assemble();
	}

}
