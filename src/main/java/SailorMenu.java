package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;

public class SailorMenu{

	ArrayList<Sailors> AvailableSailors = new ArrayList<Sailors>();
	ArrayList<Sailors> SailorsAboard = new ArrayList<Sailors>();

	public SailorMenu(Boat playerObject){
		copyMembersFromPlayer(playerObject);
		hireOrFire(playerObject);
	//	displayAvailableCrew();
	//	hireCrewDecision(playerObject);
	}
	
	private void copyMembersFromPlayer(Boat playerObject){
		if(playerObject.AnySailors()){
			for(int i = 0; i < playerObject.getSailorCount(); i++){
				this.SailorsAboard.add(playerObject.getSailors(i));
			}
		}
	}
	
	private void displayPlayerSailors(Boat playerObject){
		System.out.println("----- Your Hired Sailors -----");
		if(playerObject.AnySailors()){
			for(int x = 0; x < getSailorCount(); x++){
				this.SailorsAboard.get(x).displayCrewmenInformation();
				System.out.println();
			}
			
		} else {
			System.out.println("\nYou don't have any crewmembers!\n");
		}
	}
	
	private int getSailorCount(){
		return this.SailorsAboard.size();
	}
	
	private void generateCrew(){
		System.out.println("----- Available Sailors for Hire -----");
		
		for(int i = 0; i < 6; i++){
			this.AvailableSailors.add(i, new Sailors());
		}
	}
	
	public void displayAvailableCrew(){
		generateCrew();
	
		for(int i = 0; i < 6; i++){
			this.AvailableSailors.get(i).displayCrewmenInformation();
			System.out.println();
		}
	//	Abstract.PressAnyKey();
	
		//System.out.println(AvailableCrewmen.get(displayCrewmenInformation() ));
	
	}

	private void hireOrFire(Boat playerObject){
		System.out.print("Are you looking to add sailors, or make changes to your current roster(Hire/fire/totals/Back): ");
		String hireChoice = Abstract.ScannerString();
		if(hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")){
			displayPlayerSailors(playerObject);
			displayAvailableCrew();
			hireCrewDecision(playerObject);
		}
		if(hireChoice.equalsIgnoreCase("total") || hireChoice.equalsIgnoreCase("t") || hireChoice.equalsIgnoreCase("3")){
			playerObject.recalculateLevels();
			playerObject.DisplayTotals();
		}
		if(hireChoice.equalsIgnoreCase("fire") || hireChoice.equalsIgnoreCase("f") || hireChoice.equalsIgnoreCase("2")){
			displayPlayerSailors(playerObject);
			fireDecision(playerObject);
		}
		
	}
	
	private void fireDecision(Boat playerObject){
		if(playerObject.getSailorCount() > 0){
			System.out.print("Choose which employee to let go (1,2,3... | 0 to quit): ");
			int fireChoice = Abstract.ScannerInt();
			if(fireChoice == 0) {
				;
			} else{
				playerObject.removeSailor(fireChoice - 1);
			}
		} else {
			System.out.println("\nYou don't have any employees to fire.\n");
		}
	}
	
	private void hireCrewDecision(Boat playerObject){
		System.out.print("Which sailors would you like to hire?(1,2,3 | B to go back): ");
		char sailorChoice = Abstract.ScannerChar();
		if(Character.isDigit(sailorChoice)){
			playerObject.addSailor(this.AvailableSailors.get(Character.getNumericValue(sailorChoice) - 1));
			playerObject.displaySailorCount();
			//hireCrewLoader(sailorChoice, playerObject);
			//playerObject.addSailor(AvailableSailors.get(Character.getNumericValue(sailorChoice) - 1));
		}
		if(getSailorCount() > 0){
			playerObject.recalculateLevels();
			playerObject.IncreaseDate();
		}
	}
	
	
}