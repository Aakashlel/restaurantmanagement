package com.ResExceptions;

public class PaymentFailedException extends RuntimeException {

	public PaymentFailedException(String message) {
		super(message);
	}

}
