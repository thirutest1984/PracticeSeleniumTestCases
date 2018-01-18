
public class MethodOverridingCar {
	
	private String type = "Vehicle";
	public static int wheels = 4;
	public String color = "blue";
	String fuel = "petrol";
	
	public String getFuel() {
		return fuel;
	}

	protected void seats() {
		int seat = 4;
		System.out.println("Car seats = "+seat);
	}

}
