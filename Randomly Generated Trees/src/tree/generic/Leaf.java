package tree.generic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Leaf {
	
	private int[] xPoints, yPoints;
	private ArrayList<Double> leafX = new ArrayList<Double>(), leafY = new ArrayList<Double>();
	private BufferedImage image;
	private boolean drop = false, randomized = false;
	private double velX = 0, velY = 5, x, y, direction;
	private Color color = Color.GREEN;
	private int finalHeight;
	
	public Leaf(int x, int y, int height, double direction){
		
		this.direction = direction;
		
		this.x = x;
		this.y = y;
		
		this.finalHeight = height;
		
		int x2 = finalHeight, y2 = finalHeight;
		
		addXPoint(x2);
		addYPoint(y2);
		
		xPoints = new int[]{x2};
		yPoints = new int[]{y2};
		
		drawToImage();
	}
	
	public void grow(){
		
		if(!drop && getHeight() < finalHeight){
			
			if(Math.random() < 0.5) {
				
				changeXPoint(1);
			} 
			else {changeXPoint(-1);}

			changeYPoint(1);
			
			xPoints = getXPoints();
			yPoints = getYPoints();
		}
		
		drawToImage();
	}
	
	public void drop(){
		
		drop = true;
	}
	
	public void update(){
		
		double time = System.currentTimeMillis();
		
		if(time % 20000 > 15000 && time % 20000 < 19000 && !randomized){
			
			randomized = true;
			color = randomColor();
		}
		
		else if(time % 20000 > 19000 && time % 20000 < 20000 && getHeight() > finalHeight / 2){
			
			drop();
		}
		
		if(drop){
			
			x += 3 * Math.cos(y / 20);
			y += 5 + (int) (((double) (finalHeight - getHeight()) / (double) finalHeight) * velY);
		}
	}
	
	public void drawToImage(){
		
		image = new BufferedImage(finalHeight * 2, finalHeight * 2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = (Graphics2D) image.getGraphics();
		
		AffineTransform at = new AffineTransform();
		at.rotate(direction, image.getWidth() / 2, image.getHeight() / 2);
		g2D.setTransform(at);
		
		g2D.setColor(color);
		int leafBase = yPoints.length / 2;
		
		for(int i = yPoints.length / 5; i < yPoints.length; i++){
			
			g2D.drawLine(xPoints[i] - (int) (leafBase * ((double) (xPoints.length - i) / (double) xPoints.length)), yPoints[i], xPoints[i] + (int) (leafBase * ((double) (xPoints.length - i) / (double) xPoints.length)), yPoints[i]);
		}
		
		g2D.setColor(Color.GRAY);
		g2D.drawPolyline(xPoints, yPoints, xPoints.length);
	}
	
	public Color randomColor(){
		
		int rand = (int) ((System.currentTimeMillis() % 80000) / 20000);
		
		switch(rand){
		
		case 1:
			
			return Color.RED;
		case 2:
			
			return Color.ORANGE;
		case 3:
			
			return Color.YELLOW;
		case 4:
			
			return Color.BLUE;
		default:
			
			return Color.MAGENTA;
		}
		
	}
	
	public void draw(Graphics g){

		update();
		g.drawImage(image, (int) x - (image.getWidth() / 2), (int) y - (image.getHeight() / 2), null);
	}
	
	public int getX() {return (int) x;}
	public int getY() {return (int) y;}
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void changeX(double x) {this.x += x;}
	public void changeY(double y) {this.y += y;}
	
	public double getVelX() {return velX;}
	public double getVelY() {return velY;}
	public void setVelX(double velX) {this.velX = velX;}
	public void setVelY(double velY) {this.velY = velY;}
	public void changeVelX(double accX) {this.velX += accX;}
	public void changeVelY(double accY) {this.velY += accY;}
	
	public int getHeight() {return (int) Math.sqrt(Math.pow(leafY.get(leafY.size() - 1) - leafY.get(0), 2) + Math.pow(leafX.get(leafX.size() - 1) - leafX.get(0), 2));}
	public int getFinalHeight() {return finalHeight;}
	
	public void addXPoint(double x) {leafX.add(x);}
	public void changeXPoint(double x) {leafX.add(leafX.get(leafX.size() - 1) + x);}
	
	public void addYPoint(double y) {leafY.add(y);}
	public void changeYPoint(double y) {leafY.add(leafY.get(leafY.size() - 1) + y);}
	
	public int[] getXPoints() {int[] tempXArray = new int[leafX.size()]; for(int i = 0; i < leafX.size(); i++) {tempXArray[i] = leafX.get(i).intValue();} return tempXArray;}
	public int[] getYPoints() {int[] tempYArray = new int[leafY.size()]; for(int i = 0; i < leafY.size(); i++) {tempYArray[i] = leafY.get(i).intValue();} return tempYArray;}
	
	public void setImage(BufferedImage image) {this.image =  image;}
	
	public double getDirection() {return direction;}
	
	public boolean isDropped() {return drop;}
}
