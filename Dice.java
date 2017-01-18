import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Random;

public class Dice implements Runnable {
	public static int diceDone = 0;
	private static final Icon ONE = new ImageIcon(Main.class.getResource("/FaceImages/one.png"));
	private static final Icon TWO = new ImageIcon(Main.class.getResource("/FaceImages/two.png"));
	private static final Icon THREE = new ImageIcon(Main.class.getResource("/FaceImages/three.png"));
	private static final Icon FOUR = new ImageIcon(Main.class.getResource("/FaceImages/four.png"));
	private static final Icon FIVE = new ImageIcon(Main.class.getResource("/FaceImages/five.png"));
	private static final Icon SIX = new ImageIcon(Main.class.getResource("/FaceImages/six.png"));
	
	private JLabel _label;
	private int value;
	private Icon face;
	Random rand = new Random();
	
	Dice() {
		value = 1;
		face = ONE;
	}
	
	public int getVal() { return value; }
	public Icon getFace() { return face; }
	public void setLabel(JLabel l) { _label = l; }
	//public void setVal(int v) { value = v; }
	//public void setFace(Icon f) { face = f; }
	
	// Gets a new value and changes the face image;
	public void roll() {
		int next = rand.nextInt(6) + 1;
		value = next;
		
		switch(next) {
		case 1:
			face = ONE;
			break;
			
		case 2:
			face = TWO;
			break;
			
		case 3:
			face = THREE;
			break;
			
		case 4:
			face = FOUR;
			break;
			
		case 5:
			face = FIVE;
			break;
		
		case 6:
			face = SIX;
			break;			
		}
		
		_label.setIcon(face);
	}
	
	public void run() {
		int timer = rand.nextInt(300) + 1;
		for (int i = 0; i < timer; i++) {
			this.roll();
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException ex) {;}
		}
	}
}
