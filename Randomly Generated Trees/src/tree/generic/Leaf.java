package tree.generic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Leaf {
	
	private int[] xPoints, yPoints;
	private ArrayList<Integer> leafX = new ArrayList<Integer>(), leafY = new ArrayList<Integer>();
	private BufferedImage image;
	private boolean drop = false, randomized = false;
	private double velY = 5, x, y, direction;
	private Color color = Color.GREEN;
	private int finalHeight;
	
	public Leaf(int x, int y, int height, double direction){
		
		this.direction = direction;
		
		this.x = x;
		this.y = y;
		
		this.finalHeight = height;
		
		int x2 = finalHeight, y2 = finalHeight;
		
		leafX.add(x2);
		leafY.add(y2);
		
		xPoints = new int[]{x2};
		yPoints = new int[]{y2};
		
		drawToImage();
	}
	
	public void grow(){
		
		if(!drop && getHeight() < finalHeight){
			
			if(Math.random() < 0.5) {
				
				leafX.add(leafX.get(leafX.size() - 1) - 1);
			} 
			else {leafX.add(leafX.get(leafX.size() - 1) +1);}
			
			leafY.add(leafY.get(leafY.size() - 1) - 1);
			
			xPoints = new int[leafX.size()];
			yPoints = new int[leafY.size()];
			
			for(int i = 0; i < leafX.size(); i++){
				
				xPoints[i] = leafX.get(i);
				yPoints[i] = leafY.get(i);
			}
			
			drawToImage();
		}
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
	public int getHeight() {return (int) Math.sqrt(Math.pow(leafY.get(leafY.size() - 1) - leafY.get(0), 2) + Math.pow(leafX.get(leafX.size() - 1) - leafX.get(0), 2));}
}
