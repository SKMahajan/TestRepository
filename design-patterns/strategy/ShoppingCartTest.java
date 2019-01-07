package com.dec.designpatterns.strategy;

public class ShoppingCartTest {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item("123", 10));
		cart.addItem(new Item("234",20));
		
		cart.pay(new PayPalStrategy("suchita@gmail.com", "such"));
		cart.pay(new CreditCardStrategy("suchita", "123456789", "123", "1/2/3"));
	}

}
