package com.model;

public enum CustomerStatus {

	RESTORED("R"), SUSPENDED("S"), OPEN("O"), CLOSED("C");

	private final String shortCode;

	CustomerStatus(String string) {
		this.shortCode = string;
	}

	public String getShortCode() {
		return this.shortCode;
	}
}
