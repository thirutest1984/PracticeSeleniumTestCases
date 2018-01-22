package com.practice.java;

public class FordCar extends MethodOverridingCar {
	
	protected void seats() {
		int seat = 6;
		System.out.println("Ford car seats = "+seat);
	}
	
	public static void main(String[] args) {
		
		MethodOverridingCar c = new FordCar();
		c.seats();

	}

}
