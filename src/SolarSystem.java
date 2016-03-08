/*This class is currently only functioning to print instructions. It does create 8 Planet objects, however they are not functional.*/
import java.util.Scanner;

public class SolarSystem {
	public SolarSystem () {
		Planet mercury = new Planet ("MERCURY", 2);
		Planet venus = new Planet ("VENUS", 1);
		Planet earth = new Planet ("EARTH", 0);
		Planet mars = new Planet ("MARS", 1);
		Planet jupiter = new Planet ("JUPITER", 2);
		Planet saturn = new Planet ("SATURN", 3);
		Planet uranus = new Planet ("URANUS", 4);
		Planet neptune = new Planet ("NEPTUNE", 5);
	}
	public void beginningInstruction() {
		System.out.println("The good robot must find the three hidden objects");
		System.out.println("The bad robot must try to deplete all of the good robots energy");
		System.out.println();
	}
	
	public String nameSelection () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of your robot?");
		return scanner.nextLine().toUpperCase();
	}
	
	
	public void options () {
		System.out.println("Type STATUS for your robot's current status");
		System.out.println("Type MOVE to change planets");
		System.out.println("Type RECHARGE to recharge to full (if you are on EARTH");
		System.out.println("Type ACTION to attack (if evil) or heal (if good)");
		System.out.println("Your turn will end after you MOVE, RECHARGE, or take ACTION");
		System.out.println();
	}
}