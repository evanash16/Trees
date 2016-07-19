package tree.pine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tree.generic.Leaf;

public class PineLeaf extends Leaf{
	
	private BufferedImage image;
	
	public PineLeaf(int x, int y, int height, double direction){
		
		super(x, y, height, direction);
		
		drawToImage();
	}
	
	public void grow(){
		
		if(getHeight() < getFinalHeight()){
			
			if(Math.random() < 0.5) {
				
				changeXPoint(Math.sin(getDirection()));
			} 
			else {changeXPoint(-Math.sin(getDirection()));}
			
			changeYPoint(Math.cos(getDirection()));
		}
		
		drawToImage();
	}
	
	public void update(){
		
	}
	
	public void drawToImage(){
		
		BufferedImage image = new BufferedImage(getFinalHeight() * 2, getFinalHeight() * 2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = (Graphics2D) image.getGraphics();
		
		g2D.setColor(Color.GREEN);
		g2D.drawPolyline(getXPoints(), getYPoints(), getXPoints().length);
		
		setImage(image);
	}
}
