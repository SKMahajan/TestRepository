package com.dec.designpatterns.builder;

public class Computer {

	//requires parameters
	private String HDD;
	private String RAM;
	
	//optional parameters
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;
	
	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	
	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}
	
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	private  Computer(ComputerBuilder builder) {
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	public static class ComputerBuilder{
		//requires parameters
		private String HDD;
		private String RAM;
		
		//optional parameters
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;
		
		public ComputerBuilder(String hdd, String ram) {
			this.HDD=hdd;
			this.RAM=ram;
		}
		
		public ComputerBuilder setGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled=isGraphicCardEnabled;
			return this;
		}
		
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled=isBluetoothEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", isGraphicCardEnabled=" + isGraphicCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
	
}























