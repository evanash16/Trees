package tree.pine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Graphics.GUI;
import tree.generic.Leaf;

public class PineCone extends Leaf{

	public PineCone(int x, int y, int height){
		
		super(x, y, height, 0);
	}
	
	public void grow(){
		
		if(getHeight() < getFinalHeight()){
			
			if(Math.random() < 0.5) {
				
				changeXPoint(0.5);
			} 
			else {changeXPoint(-0.5);}
			
			changeYPoint(1);
		}
		
		drawToImage();
	}
	
	public void update(){
		
		if(getHeight() == getFinalHeight()){
			
			if(Math.random() < 0.005){
				
				drop();
			}
		}
		
		if(isDropped()){
				
			changeVelY(10);
			changeY(getVelY());
		}
	}
	
	public void drawToImage(){
		
		BufferedImage image = new BufferedImage(getFinalHeight() * 2, getFinalHeight() * 2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = (Graphics2D) image.getGraphics();
		
		g2D.setColor(new Color(127, 106, 69));
		g2D.drawPolyline(getXPoints(), getYPoints(), getXPoints().length);
		
		int startX = getXPoints()[0];
		int startY = getYPoints()[0];
		
		int endX = getXPoints()[getXPoints().length - 1];
		int endY = getYPoints()[getYPoints().length - 1];
		
		int[] xPoints = new int[]{startX, startX - (getHeight() / 5), endX, startX + (getHeight() / 5)};
		int[] yPoints = new int[]{startY, startY + (getHeight() / 20), endY, startY + (getHeight() / 20)};
		
		g2D.fillPolygon(xPoints, yPoints, 4);
		
		setImage(image);
	}
}
