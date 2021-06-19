package com.jayram.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Circles setter called!");
		this.name = name;
		throw new RuntimeException();
	}
	
}
