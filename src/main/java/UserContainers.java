package src.main.java;

public interface UserContainers{
	public void setMaximumContainers(int userDefinedMaxContainers);
	public int getMaximumContainers();
	public void setCurrentContainers(int userDefinedCurrentContainers);
	public int getCurrentContainers();
	public boolean isEmptyShip();
	public boolean isFullShip();
	public void getContainerReadout();

}
class ShipContainers extends User{
	int maximumContainers;
	int currentContainers;

	public ShipContainers(String userDefinedName){
			super(userDefinedName);
			this.maximumContainers = 100;
			this.currentContainers = 0;
	}

	public ShipContainers(String userDefinedName, int[] getDefaultUserShip){
			super(userDefinedName, getDefaultUserShip);
			this.maximumContainers = 100;
			this.currentContainers = 0;
	}

	public void setMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}

	public int getMaximumContainers(){
		return this.maximumContainers;
	}

	public void setCurrentContainers(int userDefinedCurrentContainers){
		this.currentContainers = userDefinedCurrentContainers;
	}

	public int getCurrentContainers(){
		return this.currentContainers;
	}

	public boolean isEmptyShip(){
		if(this.currentContainers == 0){
			return true;
		} else {
			return false;
		}
	}

	public boolean isFullShip(){
		if(this.currentContainers == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}

	public void getContainerReadout(){
		System.out.println("Maximum Containers: " + this.maximumContainers);
		System.out.println("Current Containers: " + this.currentContainers + "\n\n");
	}

}