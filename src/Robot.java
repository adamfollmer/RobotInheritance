import java.util.Scanner;

public class Robot {
	SolarSystem solarSystem = new SolarSystem();
	String name;
	int powerLevel = 10;
	String location = "EARTH"; // Originally intended to have this variable be a
								// Planet, not a String.
	boolean isEvil;

	public Robot(String Name, boolean IsEvil) {
		name = Name;
		isEvil = IsEvil;
	}

	public void moveRobot(Robot robot) {
		SolarSystem solarSystem = new SolarSystem();
		System.out.println("Where do you want to move to?:");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine().toUpperCase();
		switch (userInput) {
		case "MERCURY":
			robot.location = "MERCURY";
			robot.powerLevel -= 2;
			System.out.println("You moved to " + robot.location + " and it cost you 2 energy.");
			break;
		case "VENUS":
			robot.location = "VENUS";
			robot.powerLevel -= 1;
			System.out.println("You moved to " + robot.location + " and it cost you 1 energy.");
			break;
		case "EARTH":
			robot.location = "EARTH";
			System.out.println("You moved to " + robot.location + " and it cost you 0 energy.");
			break;
		case "MARS":
			robot.location = "MARS";
			robot.powerLevel -= 1;
			System.out.println("You moved to " + robot.location + " and it cost you 1 energy.");
			break;
		case "JUPITER":
			robot.location = "JUPITER";
			robot.powerLevel -= 2;
			System.out.println("You moved to " + robot.location + " and it cost you 2 energy.");
			break;
		case "SATURN":
			robot.location = "SATURN";
			robot.powerLevel -= 3;
			System.out.println("You moved to " + robot.location + " and it cost you 3 energy.");
			break;
		case "URANUS":
			robot.location = "URANUS";
			robot.powerLevel -= 4;
			System.out.println("You moved to " + robot.location + " and it cost you 4 energy.");
			break;
		case "NEPTUNE":
			robot.location = "NEPTUNE";
			robot.powerLevel -= 5;
			System.out.println("You moved to " + robot.location + " and it cost you 5 energy.");
			break;
		default:
			System.out.println("Planet not processed, turn skipped.");
			break;
		}

	}

	public void rechargeRobot(Robot robot) {
		if (robot.location.equals("EARTH")) {
			robot.powerLevel = 10;
			System.out.println("Your power level returned to 10");
		} else {
			System.out.println("You're not on EARTH and can't recharge.");
		}
	}

	public void robotStatus(Robot robot) {
		System.out.println(robot.name + ":");
		System.out.println("You are on " + robot.location);
		System.out.println("You have " + robot.powerLevel + " energy.");
	}
	
	public void endCredits (EvilRobot evilRobot, GoodRobot goodRobot){
		if (evilRobot.powerLevel <= 0) {
			System.out.println();
			System.out.println(evilRobot.name + " has lost all power.");
			System.out.println(goodRobot.name + " wins!");
		} else if (goodRobot.powerLevel <= 0) {
			System.out.println();
			System.out.println(goodRobot.name + " has lost all power.");
			System.out.println(evilRobot.name + " wins!");
		} else if (goodRobot.checkTriforce(goodRobot) == true){
			System.out.println();
			System.out.println(goodRobot.name + " has collected the three parts of the Triforce");
			System.out.println(goodRobot.name + " wins!");
		} else {
			System.out.println();
			System.out.println("You shouldn't see this.");
		}
		System.exit(1);
	} 

}
