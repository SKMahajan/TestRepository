package com.dec.designpatterns.decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void assemble() {
		System.out.println("adding features for luxury car");
	}
}
