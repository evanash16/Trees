import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI extends JFrame{

	public static void main(String[] args) {
		
		GUI gui = new GUI();
	}
	
	public GUI(){
		
		super("Randomly Generated Trees");
		
		init();
	}
	
	public void init(){
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		setSize(tk.getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		setVisible(true);
	}

}
