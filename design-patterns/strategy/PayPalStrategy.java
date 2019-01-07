package com.dec.designpatterns.strategy;

public class PayPalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;
	
	public PayPalStrategy(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid using Paypal");
	}

}
