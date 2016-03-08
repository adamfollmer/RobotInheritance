/*This class is not currently used as there was difficulty calling the created planet objects within the Robot class.*/
public class Planet {
	String location;
	int energyDrain;
	
	public Planet (String Location, int EnergyDrain){
		location = Location;
		energyDrain = EnergyDrain;
	}
	
	public int drainEnergy (Robot robot, Planet map){
		robot.powerLevel = robot.powerLevel - map.energyDrain;
		return robot.powerLevel;
	}
}
