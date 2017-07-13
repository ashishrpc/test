package com.designPattern.structural;

import java.io.IOException;

/**
 * @author ashish.prasad
 * 
 * Proxy in the Real World :
  A Proxy can also be defined as a surrogate. In the real work a cheque or credit card is a proxy for what is in our bank account.  
  It can be used in place of cash, which is what is needed, and provides a means of accessing that cash when required. 
  And that's exactly what the Proxy pattern does - controls and manage access to the object they are "protecting".
  
  GoF : Allows for object level access control by acting as a pass through entity or a placeholder object. 
  
  It is used:

	It can be used in Virtual Proxy scenario---Consider a situation where there is multiple database call to extract huge size image. Since this is an expensive operation so here we can use the proxy pattern which would create multiple proxies and point to the huge size memory consuming object for further processing. The real object gets created only when a client first requests/accesses the object and after that we can just refer to the proxy to reuse the object. This avoids duplication of the object and hence saving memory.
	It can be used in Protective Proxy scenario---It acts as an authorization layer to verify that whether the actual user has access the appropriate content or not. For example, a proxy server which provides restriction on internet access in office. Only the websites and contents which are valid will be allowed and the remaining ones will be blocked.
	It can be used in Remote Proxy scenario---A remote proxy can be thought about the stub in the RPC call. The remote proxy provides a local representation of the object which is present in the different address location. Another example can be providing interface for remote resources such as web service or REST resources.
	It can be used in Smart Proxy scenario---A smart proxy provides additional layer of security by interposing specific actions when the object is accessed. For example, to check whether the real object is locked or not before accessing it so that no other objects can change it.

 *
 */
public class ProxyDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
		
	}

}

/**
 * @author ashish.prasad
 * Since we code Java in terms of interfaces, here is our interface and its implementation class.
 */
interface CommandExecutor {

	public void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {
	@Override
	public void runCommand(String cmd) throws IOException {
                //some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}

/**
 * @author ashish.prasad
 *Proxy Class:
	Now we want to provide only admin users to have full access of above class, if the user is not admin then only limited commands will be allowed. Here is our very simple proxy class implementation.
 */
class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd){
		if("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin=true;
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin){
			executor.runCommand(cmd);
		}else{
			if(cmd.trim().startsWith("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				executor.runCommand(cmd);
			}
		}
	}

}

