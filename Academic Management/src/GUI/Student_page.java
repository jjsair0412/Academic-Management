package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Student.Student_DB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_page extends JFrame{
	JButton myinfo;
	Student_DB stDB = null;
	public Student_page() {
		setTitle("학생 페이지입니다");
		setSize(1000,500); 
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		myinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				stDB.selectRead();
				
			}
		});
		
		
		setVisible(true);

	}
}
