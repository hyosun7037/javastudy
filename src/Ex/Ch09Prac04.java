package Ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ch09Prac04 extends JFrame{
	
	public Ch09Prac04(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		JButton [] btn = new JButton[2];
		Color [] color = {Color.black, Color.red};
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(Integer.toString(i));
			c.add(btn[i]);
			btn[i].setBackground(color[i]);
		}
		
	
		setSize(800,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ch09Prac04();
	}

}
