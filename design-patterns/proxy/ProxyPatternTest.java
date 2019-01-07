package com.dec.designpatterns.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {

		CommandExecutor executor = new CommandExecutorProxy("suchita", "suchi");
		try {
			executor.runCommand("rmdir suchita");
			executor.runCommand("D:");
			executor.runCommand("mkdir suchita");
		}catch(Exception e) {
			System.out.println("Exception message : "+e.getMessage());
		}
	}

}
