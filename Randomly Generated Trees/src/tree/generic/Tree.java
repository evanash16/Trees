package tree.generic;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tree {

	private ArrayList<Integer> xPoints = new ArrayList<Integer>(), yPoints = new ArrayList<Integer>();
	private Trunk trunk;
	
	public Tree(double x, double y){
		
		trunk = new Trunk(x, y);
	}
	
	public void grow(){
		
		growTrunk((double) (1 / (double) (1 + (trunk.getHeight() / 50))));
	}
	
	public void draw(Graphics g){
		
		trunk.draw(g);
	}
	
	public void setTrunk(Trunk trunk) {this.trunk = trunk;}
	public void growTrunk(double chance) {trunk.grow();}
}
