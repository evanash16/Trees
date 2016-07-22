package tree.pine;

import tree.generic.Branch;
import tree.generic.Trunk;

public class PineTrunk extends Trunk{

	public PineTrunk(double x, double y) {
		
		super(x, y);
	}
	
	public void grow(){
		
		if(Math.random() < 0.5){
			
			changeXPoint(-1);
		}
		
		else{
			
			changeXPoint(1);
		}
		
		changeYPoint(-1);
		
		growBranches(0.25);
		
		if(getHeight() > 50 && Math.random() < 0.15) {
			if(Math.random() < 0.5){addBranch(new PineBranch(lastXPoint(), lastYPoint(), Math.PI / 4));}
			else{addBranch(new PineBranch(lastXPoint(), lastYPoint(), 3 * Math.PI / 4));}
		}
	}
}
