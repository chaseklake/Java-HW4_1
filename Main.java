import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	public static int threadsDone = 0;
	JLabel lblOne = new JLabel("");
	JLabel lblTwo = new JLabel("");
	JLabel lblThree = new JLabel("");
	JLabel lblFour = new JLabel("");
	JLabel lblFive = new JLabel("");
	JButton btnRoll = new JButton("Roll");
	private Dice[] dice = new Dice[5];
	
	public Main() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (int i = 0; i < 5; i++) {
			dice[i] = new Dice();
		}
		
		lblOne.setIcon(dice[0].getFace());
		dice[0].setLabel(lblOne);
		getContentPane().add(lblOne);
		
		
		lblTwo.setIcon(dice[1].getFace());
		dice[1].setLabel(lblTwo);
		getContentPane().add(lblTwo);
		
		lblThree.setIcon(dice[2].getFace());
		dice[2].setLabel(lblThree);
		getContentPane().add(lblThree);
		
		lblFour.setIcon(dice[3].getFace());
		dice[3].setLabel(lblFour);
		getContentPane().add(lblFour);
		
		lblFive.setIcon(dice[4].getFace());
		dice[4].setLabel(lblFive);
		getContentPane().add(lblFive);
		
		btnRoll.addActionListener(this);
		getContentPane().add(btnRoll);
		
		this.setSize(600, 200);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRoll) {
			//keep rolling dice
			threadsDone = 0;
			Thread[] t = new Thread[5];
			for (int i = 0; i < 5; i++) {
				t[i] = new Thread(dice[i]);
				t[i].start();
			}
		}
	}
	
	public static void main (String[] args) {
		Main m = new Main();
	}
}
