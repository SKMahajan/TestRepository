package com.dec.designpatterns.builder;

public class BuilderPatternTest {

	public static void main(String[] args) {
		Computer comp = new Computer.ComputerBuilder("MyHDD", "MyRAM").setBluetoothEnabled(false)
				.setGraphicCardEnabled(true).build();
		System.out.println(comp);
	}

}
