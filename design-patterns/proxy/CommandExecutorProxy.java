package com.dec.designpatterns.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pswd) {
		if("suchita".equals(user) && "suchu".equals(pswd)) isAdmin=true;
		executor=new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin) {
			executor.runCommand(cmd);
		}else {
			if(cmd.trim().startsWith("rmdir")) {
				throw new Exception("rmdir command is not allowed for non admin users");
			}else {
				executor.runCommand(cmd);
			}
		}
		
		
	}

}
