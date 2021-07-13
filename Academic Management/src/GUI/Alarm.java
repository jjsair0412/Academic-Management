package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Alarm extends JFrame{
	public String Alarm;
	public Alarm(String Alarm) {
		this.Alarm = Alarm;
		setTitle("학사정보 시스템");
		setSize(300, 300);
		setContentPane(new MyPanel()); 
		setVisible(true);
	
	
	}
	// 값을 그려줄 MyPanel
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			g.drawString(Alarm, 30, 30);

		}
	}
	
	
	
}
