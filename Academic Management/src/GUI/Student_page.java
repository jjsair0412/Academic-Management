package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class Student_page extends JFrame{
	public Student_page() {
		setTitle("학생 페이지입니다");
		setSize(1000,500); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		
		setVisible(true);

	}
}
