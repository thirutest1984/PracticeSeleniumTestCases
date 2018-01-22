package com.practice.java;

public class AudiCar extends MethodOverridingCar{
	
	public int speed = 150;
	
	public void printDetails() {
		System.out.println("Wheels of Audi: "+wheels);
		System.out.println("Speed of Audi: "+speed);
//		System.out.println("Wheels of Audi "+type);
		seats();
	}

	public static void main(String[] args) {
		AudiCar a = new AudiCar();
		a.printDetails();
		System.out.println("Color of Audi: "+a.color);
		System.out.println("Fuel of Audi: "+a.fuel);
	}

}
