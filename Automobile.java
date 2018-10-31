package cp120.assignments.assignment003;


public class Automobile {

	private final int MPG = 33;             //in miles per gallon
	private final double FUEL_TANK_SIZE = 13.2; //in gallons
	private final double GAS_PRICE = 4.00; //in dollars per gallon
	private double fuelLevel; //in gallons
	private double odometerReading; //in miles
    
    public Automobile(double fuelLevel, double odometerReading) {
     this.fuelLevel = fuelLevel;
     this.odometerReading = odometerReading;
    }
    
    //returns the current fuelLevel
    public double getFuelLevel() {
    	return fuelLevel;
    }
     //returns the current odometerReading.
    public double getMileage() {
    	return odometerReading;
    }
    //returns the farthest distance car can travel on the fuel level.
    public double getRange() {
       	double distance = getFuelLevel() * MPG;
    	return distance;
    }
    
    //returns the private FUEL_TANK_SIZE constant
    public double getFuelTankSize() {
    	 return FUEL_TANK_SIZE;
    }
    //
    private void setFuelLevel(double currentLevel) {
    	
    	fuelLevel = currentLevel;
    }
    //Determine if the Automobile has enough fuel to drive the requested distance
    public void drive(double distance) {
    	double currentDistance = getRange(); //fuelLevel*MPG
       	
    	if( distance > currentDistance) {
    		
    		System.out.println("There is not enough fuel to drive the " + distance +" miles");
    	
    	    }
    	else {
    		double fuelSpent = distance/MPG;
    		setFuelLevel(fuelLevel - fuelSpent);
    		System.out.println("You drove " +distance+" miles. Your fuel level is "+ getFuelLevel()+" gallons.");
    	}
    }
     
    public void refuel(double dollarAmount) {
    	double canBuyGallons = dollarAmount/GAS_PRICE;
    	//double payFullTank = GAS_PRICE*FUEL_TANK_SIZE;
    	// double currentFuelLevel = GAS_PRICE*fuelLevel;
    	//If the entire dollarAmount worth of fuel cannot fit into the tank, stop fueling
    	double emptyFuelLevel = getFuelTankSize() - getFuelLevel(); 
    	if (emptyFuelLevel == 0) {
    		System.out.println("The fuel tank is already full.");
    		return;
    	}
    	 //if the dollarAmount of fuel fills less than a full tank, 
    		//display �Please pay XX.XX dollars for X.XX gallons.�  to add to full gas tank?????
    		if(canBuyGallons < emptyFuelLevel) {
    			
    			   			
    			System.out.println("Please pay $"+ GAS_PRICE * emptyFuelLevel + " for " + emptyFuelLevel);
    		}
    		if (canBuyGallons >= emptyFuelLevel){
    			 double payForGas = emptyFuelLevel*GAS_PRICE;
    			 double change = dollarAmount - payForGas;
    				
    				System.out.println("Please pay "+dollarAmount+" dollars for "+canBuyGallons+" gallons. Your change is "+ change+" dollars");
    		}
    			}   
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Automobile a = new Automobile(10,10000);
	a.refuel(60);
	a.drive(350);
	a.refuel(30);
	a.drive(350);
		//a.GAS_PRICE = 13;

	}

}
