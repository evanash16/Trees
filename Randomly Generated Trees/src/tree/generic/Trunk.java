package tree.generic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Trunk {

	private ArrayList<Double> xPoints = new ArrayList<Double>(), yPoints = new ArrayList<Double>();
	private ArrayList<Branch> branches = new ArrayList<Branch>();
	private Color color = new Color(127, 106, 69);
	
	public Trunk(Double x, Double y){
		
		xPoints.add(x);
		yPoints.add(y);
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
		
		if(getHeight() > 150 && Math.random() < 0.05){
			
			if(Math.random() < 0.5){branches.add(new Branch(lastXPoint(), lastYPoint(), Math.PI / 4, color));}
			else{branches.add(new Branch(lastXPoint(), lastYPoint(), 3 * Math.PI / 4, color));}
		}
	}
	
	public void draw(Graphics g){
		
		int[] tempXPoints = new int[xPoints.size()], tempYPoints = new int[yPoints.size()];
		
		for(int i = 0; i < tempXPoints.length; i++){
			
			tempXPoints[i] = xPoints.get(i).intValue();
			tempYPoints[i] = yPoints.get(i).intValue();
		}
		
		g.setColor(color);
		g.drawPolyline(tempXPoints, tempYPoints, tempXPoints.length);
		
		int trunkBase = tempXPoints.length / 50;
		
		for(int i = 0; i < tempXPoints.length; i++){
			
			g.drawLine(tempXPoints[i] - (int) (trunkBase * ((double) (tempXPoints.length - i) / (double) tempXPoints.length)), tempYPoints[i], tempXPoints[i] + (int) (trunkBase * ((double) (tempXPoints.length - i) / (double) tempXPoints.length)), tempYPoints[i]);
		}

		for(Branch b: branches){
			
			b.draw(g);
		}
	}
	
	public int getHeight(){return yPoints.size();}
	public int getX() {return xPoints.get(0).intValue();}
	public int getY() {return yPoints.get(0).intValue();}
	
	public void addXPoint(double x) {xPoints.add(x);}
	public void changeXPoint(double x) {xPoints.add(xPoints.get(xPoints.size() - 1) + x);}
	public double lastXPoint() {return xPoints.get(xPoints.size() - 1);}
	
	public void addYPoint(double y) {yPoints.add(y);}
	public void changeYPoint(double y) {yPoints.add(yPoints.get(yPoints.size() - 1) + y);}
	public double lastYPoint() {return yPoints.get(yPoints.size() - 1);}
	
	public void addBranch(Branch b) {branches.add(b);}
	public void growBranches(double chance) {for(Branch b: branches) {if(b.getEndY() < yPoints.get(0) && Math.random() < chance) {b.grow();}}}

	public void setColor(Color color) {this.color = color;}
	public Color getColor() {return color;}
}
