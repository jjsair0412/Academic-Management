package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Loading extends JFrame{
	public JLabel jlabel;
	public Container c= getContentPane();
	public Loading() {
		setTitle("�ε�ȭ��"); 
		setSize(1000,500); 
		// �����ư
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
	
		jlabel = new JLabel("��ø���ٷ��ּ���");
		c.add(jlabel);
		
		
		setVisible(true);
	}
	public void cut() {
		dispose();
	}
	
	
}

