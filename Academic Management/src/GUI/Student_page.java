package GUI;

import javax.print.attribute.standard.Severity;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Service.Info.Student_All_Info;
import SocketConnection.Server;
import SocketConnection.StudentClient;
import Student.Student_DB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_page extends JFrame {
	JTextField messageText = null;
	private JButton myinfo;	
	private Student_DB stDB = new Student_DB();
	
	public Student_page(String myId) {
		
		setTitle("학생 페이지입니다");
		setSize(1000,500); 
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		myinfo = new JButton("내 정보 불러오기");
		c.add(myinfo);
		myinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stDB.selectRead(myId);
				
			}
		});
		
		
		setVisible(true);
		

	}
}
