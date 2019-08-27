package com.rodrigo.starwars.service;

public class ServiceUnavailable extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceUnavailable(String msg) {
		super(msg);
	}
}
