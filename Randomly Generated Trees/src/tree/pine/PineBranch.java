package tree.pine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import tree.generic.Branch;

public class PineBranch extends Branch{

	public PineBranch(double x, double y, double direction, Color color) {
		
		super(x, y, direction, color);
	}
	
	public void grow(){
			
		if(Math.random() < 0.5){
				
			changeYPoint(Math.sin(getDirection()));
		}
		else{
				
			changeYPoint(-1.25 * Math.sin(getDirection()));
		}
			
		changeXPoint((int) (Math.signum(Math.cos(getDirection()))));
		
		if(Math.random() < 0.5){
			
			Point randomPoint = randomPoint(5);
			
			if(randomPoint != null){
				
				if(getLength() > 10 && Math.random() < 0.5){
					
					addLeaf(new PineLeaf(randomPoint.x, randomPoint.y, 20, getDirection() - Math.PI / 2));
				} 
				else{
					
					addLeaf(new PineLeaf(randomPoint.x, randomPoint.y, 20, getDirection() + Math.PI / 2));
				}
				
				if(Math.random() < 0.005){
					
					addLeaf(new PineCone(randomPoint.x, randomPoint.y, 20));
				}
			}
		}
	}
	
	public void draw(Graphics g){
		
		super.draw(g);
	}
}
