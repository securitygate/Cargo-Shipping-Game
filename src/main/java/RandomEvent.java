package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class RandomEvent{

	public void noFuel(Boat playerObject){
		System.out.println("Beep boop -- No Fuel");
	}
	
	public static void RandomOccurrence(Boat playerObject){
		int OccurrenceValue = (Abstract.GetRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("Either because of poor structural holds, or weather");
			System.out.println("you have " + " containers go overboard.");
			
			Abstract.PressAnyKey();
		}
		//System.out.println(OccurrenceValue);
	}
	
	public static void CannotLeavePort(Boat playerObject){
		int OccurrenceValue = (Abstract.GetRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("Other freighters are moving slowly leaving port. ");
			System.out.println("Because of this, it takes a day of slow motoring to leave.");
			Abstract.PressAnyKey();
		}
	}
	
	public static void CannotEnterPort(Boat playerObject){
		int OccurrenceValue = (Abstract.GetRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("A backup at the port has created a line of freighters waiting to enter the port. ");
			System.out.println("Because of this, you are now waiting to finally enter the port.");
			Abstract.PressAnyKey();
			// Repeat
		}
	}
	
	public static void LongshoremanStrike(Boat playerObject){
		int OccurrenceValue = (Abstract.GetRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("The longshoremen are striking in the port, and containers are not being loaded or unloaded");
			System.out.println("Your ship sits at the port waiting for the strike to end.");
			Abstract.PressAnyKey();
			//Repeat
		}
	}

	public static void SailorOverboard(){
		
	}
	
	public void GoodEvent(){
		
	}

		
	
}