package com.dec.designpatterns.decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		System.out.println("adding features of sports car");
	}
}
