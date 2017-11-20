package com.designPattern.behavioral;

import java.util.Scanner;

/* https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
 * >Chain of responsibility design pattern is one of the behavioral design pattern.
 * >Chain of responsibility pattern is used to achieve loose coupling in software design where a request from client is 
 * passed to a chain of objects to process them. Then the object in the chain will decide themselves who will be processing 
 * the request and whether the request is required to be sent to the next object in the chain or not.
 * >Ex. we can have multiple catch blocks in a try-catch block code
 * > Ex. ATM Dispense machine
 * 
 * > we can implement this solution easily in a single program itself but then the complexity will increase and the solution will be tightly coupled. So we will create a chain of dispense systems to dispense bills of 1000$, 500$ and 100$.
 */
public class ChainOfResponsibilityATMDispense {

	private DispenseChain c1;

	public ChainOfResponsibilityATMDispense() {
		// initialize the chain
		this.c1 = new Dollar1000Dispenser();
		DispenseChain c2 = new Dollar500Dispenser();
		DispenseChain c3 = new Dollar100Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}
	public static void main(String[] args) {
		ChainOfResponsibilityATMDispense atmDispenser = new ChainOfResponsibilityATMDispense();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 100 != 0) {
				System.out.println("Amount should be in multiple of 100s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}

	}

}


/**
 * @author ashish.prasad
 * We can create a class Currency that will store the amount to dispense and used by the chain implementations.
 *
 */
class Currency {

	private int amount;
	
	public Currency(int amt){
		this.amount=amt;
	}
	
	public int getAmount(){
		return this.amount;
	}
}

/**
 * @author ashish.prasad
 * The base interface should have a method to define the next processor in the chain and the method that will process the request. Our ATM Dispense interface will look like below
 *
 */
interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}

class Dollar1000Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 1000){
			int num = cur.getAmount()/1000;
			int remainder = cur.getAmount() % 1000;
			System.out.println("Dispensing "+num+" 1000$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}

class Dollar500Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 500){
			int num = cur.getAmount()/500;
			int remainder = cur.getAmount() % 500;
			System.out.println("Dispensing "+num+" 500$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}

class Dollar100Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 100){
			int num = cur.getAmount()/100;
			int remainder = cur.getAmount() % 100;
			System.out.println("Dispensing "+num+" 100$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}