package tree.pine;

import tree.generic.Branch;

public class PineBranch extends Branch{

	public PineBranch(double x, double y, double direction) {
		
		super(x, y, direction);
	}
	
	public void grow(){
			
		if(Math.random() < 0.5){
				
			changeYPoint((int) (Math.sin(getDirection())) + (getLength() / 200));
		}
			
		else{
				
			changeYPoint((int) (Math.sin(getDirection())) + (getLength() / 200));
		}
			
		changeXPoint((int) (Math.signum(Math.cos(getDirection()))));
	}
}
