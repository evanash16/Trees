package Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import tree.generic.Tree;
import tree.pine.PineTree;

public class GUI extends JFrame{
	
	public static Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private Tree tree;
	private Thread t;
	
	public static void main(String[] args) {
		
		GUI gui = new GUI();
	}
	
	public GUI(){
		
		super("Randomly Generated Trees");
		
		init();
	}
	
	public void init(){
		
		setSize(screensize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		tree = new PineTree(getWidth() / 2, 5 * (getHeight() / 6));

		setVisible(true);
		
		while(isVisible()){
			
			if(System.currentTimeMillis() % 10 == 0){
				
				repaint();
			}
		}
	}

	public void paint(Graphics g){
		
		BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g2 = buffer.getGraphics();
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		tree.grow();
		tree.draw(g2);

		g.drawImage(buffer, 0, 0, null);
	}
}
