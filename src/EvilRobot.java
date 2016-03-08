import java.util.Scanner;

public class EvilRobot extends Robot {
	int darkSideStrength;

	public EvilRobot(String Name, boolean isEvil) {
		super(Name, isEvil);
		darkSideStrength = 2;
	}

	public void dealDamage(EvilRobot self, GoodRobot target) {
		if (self.location.equals(target.location)) {
			target.powerLevel = target.powerLevel - self.darkSideStrength;
			self.powerLevel--;
			System.out.println("Both robots are on the same planet, so the damage is amplified");
			System.out.println(self.name + " did " + self.darkSideStrength + " damage to " + target.name);
			System.out.println(self.name + " used 1 energy to attack.");
			System.out.println();
			}
		 else {
			target.powerLevel--;
			self.powerLevel--;
			System.out.println("You weren't on the same planet, so it wasn't as effective.");
			System.out.println(self.name + " did 1 damage to " + target.name);
			System.out.println(self.name + " used 1 energy to attack.");
			System.out.println();
		}
	}

	public void turn(EvilRobot evilRobot, GoodRobot goodRobot) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Player 2: What do you want to do?:");
		String userInput = scanner.nextLine().toUpperCase();
		while (userInput.equals("STATUS")) {
			goodRobot.robotStatus(evilRobot);
			userInput = scanner.nextLine().toUpperCase();
		}
		switch (userInput) {
		case "MOVE":
			evilRobot.moveRobot(evilRobot);
			System.out.println();
			evilRobot.checkPlanet(evilRobot);
			break;
		case "ACTION":
			evilRobot.dealDamage(evilRobot, goodRobot);
			break;
		case "RECHARGE":
			evilRobot.rechargeRobot(evilRobot);
			break;
		default:
			System.out.println("Turn forfeited");
			break;
		}
	}

	public void checkPlanet (EvilRobot evilRobot) {
		if (evilRobot.location.equals("MERCURY")){
			evilRobot.darkSideStrength += 3;
			System.out.println("Your dark side strength grows by 3.");
			System.out.println();
		} else {
			System.out.println("More power is out there...");
			System.out.println();
		}
	}

}
