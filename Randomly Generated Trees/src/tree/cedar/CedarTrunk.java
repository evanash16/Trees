package tree.cedar;

import java.awt.Color;

import tree.generic.Trunk;

public class CedarTrunk extends Trunk{

	public CedarTrunk(double x, double y) {
		
		super(x, y);
		
		setColor(new Color(119, 17, 0));
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
		
		if(getHeight() > 100 && Math.random() < 0.15) {
			if(Math.random() < 0.5){addBranch(new CedarBranch(lastXPoint(), lastYPoint(), Math.PI / 4, getColor()));}
			else{addBranch(new CedarBranch(lastXPoint(), lastYPoint(), 3 * Math.PI / 4, getColor()));}
		}
	}
}
