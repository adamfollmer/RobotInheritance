import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SolarSystem solarSystem = new SolarSystem();
		Scanner scanner = new Scanner(System.in);
		String user1Name;
		String user2Name;
		
		solarSystem.beginningInstruction();
		System.out.println("Player 1 - You are good!:");
		user1Name = solarSystem.nameSelection();
		System.out.println();
		System.out.println("Player 2 - You are evil!:");
		user2Name = solarSystem.nameSelection();
		System.out.println();
		
		GoodRobot player1 = new GoodRobot (user1Name, false);
		EvilRobot player2 = new EvilRobot (user2Name, true);

		while (player1.powerLevel >= 1 && player2.powerLevel >= 1 && player1.checkTriforce(player1) == false)  {
			solarSystem.options();
			player1.turn(player1,player2);
			player2.turn(player2, player1);
		}
		
		player1.endCredits(player2, player1);

	}

}
