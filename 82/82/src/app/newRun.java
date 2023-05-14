package app;

import lejos.hardware.Button;

public class newRun {
	private static DataExchange DE = new DataExchange();
	private static LineFollower LFObj  = new LineFollower(DE);
	private static ColorSensor CSObj = new ColorSensor (DE);
	
	public static void main(String[] args) {
		CSObj.start();
		LFObj.start();
		while(!(Button.getButtons() !=0)) {
			//break when button is pressed
			break;
		}
		
	}

}