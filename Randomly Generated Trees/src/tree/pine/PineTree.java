package tree.pine;

import tree.generic.Tree;

public class PineTree extends Tree{
	
	public PineTree(int x, int y) {
		
		super(x, y);
		
		setTrunk(new PineTrunk(x, y));
	}
	
	public void grow(){
		
		growTrunk(1);
	}
}
