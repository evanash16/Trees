package tree.pine;

import tree.generic.Tree;

public class PineTree extends Tree{
	
	public PineTree(int x, int y) {
		
		super(x, y);
		
		setTrunk(new PineTrunk(x, y));
		setType("Pine");
	}
	
	public void grow(){
		
		growTrunk((double) 1 / (double) (1 + (getHeight() / 50)));
	}
}
