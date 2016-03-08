import java.util.Scanner;

public class GoodRobot extends Robot {
	int lightSideStrength = 1;
	boolean hasPieceOne = false;
	boolean hasPieceTwo = false;
	boolean hasPieceThree = false;

	public GoodRobot(String Name, Boolean isEvil) {
		super(Name, isEvil);
	}

	public void healSelf(GoodRobot goodRobot) {
		if (goodRobot.powerLevel + goodRobot.lightSideStrength <= 10) {
			goodRobot.powerLevel = goodRobot.powerLevel + goodRobot.lightSideStrength;
			System.out.println(goodRobot.name + " has healed to " + goodRobot.powerLevel + " power level.");
			System.out.println();
		} else {
			System.out.println("You are already at max power level");
		}

	}

	public void turn(GoodRobot goodRobot, EvilRobot evilRobot) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Player 1: What do you want to do?:");
		String userInput = scanner.nextLine().toUpperCase();
		while (userInput.equals("STATUS")) {
			goodRobot.robotStatus(goodRobot);
			System.out.println();
			System.out.println("What next?");
			userInput = scanner.nextLine().toUpperCase();
		}
		switch (userInput) {
		case "MOVE":
			goodRobot.moveRobot(goodRobot);
			System.out.println();
			goodRobot.checkPlanet(goodRobot);
			break;
		case "ACTION":
			goodRobot.healSelf(goodRobot);
			break;
		case "RECHARGE":
			goodRobot.rechargeRobot(goodRobot);
			break;
		default:
			System.out.println("Turn forfeited");
			break;
		}
		if (goodRobot.powerLevel <= 0 || goodRobot.checkTriforce(goodRobot) == true){
			goodRobot.endCredits(evilRobot, goodRobot);
		}

	}

	public void checkPlanet(GoodRobot goodRobot) {
		if (goodRobot.location.equals("VENUS")) {
			goodRobot.lightSideStrength += 2;
			goodRobot.hasPieceTwo = true;
			System.out.println("You collected the Northern Triforce piece and gained 2 light side strength!");
			System.out.println();
		} else if (goodRobot.location.equals("URANUS")) {
			goodRobot.hasPieceOne = true;
			System.out.println("You collected the Southwestern Triforce piece!");
			System.out.println();
		} else if (goodRobot.location.equals("JUPITER")) {
			goodRobot.hasPieceThree = true;
			System.out.println("You collected the Southeastern Triforce piece!");
			System.out.println();
		} else {
			System.out.println("No new pieces found. There are more pieces of the Triforce remaining.");
			System.out.println();
		}
	}

	public boolean checkTriforce(GoodRobot goodRobot) {
		if (goodRobot.hasPieceOne && goodRobot.hasPieceTwo && goodRobot.hasPieceThree) {
			System.out.println("WOW!");
			System.out.println();
			return true;
		} else {
			return false;
		}
	}

}
