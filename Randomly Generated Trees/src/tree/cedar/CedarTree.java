package tree.cedar;

import tree.generic.Tree;

public class CedarTree extends Tree{
	
	public CedarTree(int x, int y) {
		
		super(x, y);
		
		setTrunk(new CedarTrunk(x, y));
		setType("Cedar");
	}
	
	public void grow(){
		
		growTrunk((double) 1 / (double) (1 + (getHeight() / 50)));
	}
}
