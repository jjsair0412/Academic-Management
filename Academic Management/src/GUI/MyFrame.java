package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class MyFrame extends JFrame{
	JButton stdButton, professorButton;
	JPanel p;
	Student_page student_page;
	Professor_page professor_page;
	public MyFrame() {
		setTitle("학사정보 시스템"); 
		setSize(1000,500); 
		// 종료버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		p = new JPanel();
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
	    
		JTextField id_Text = new JTextField("여기에 ID 입력해주세요");
		id_Text.setBounds(10, 50, 2500, 30);
		
		JTextField pw_Text = new JTextField("여기에 pwd 입력해주세요");
		pw_Text.setBounds(10, 50, 2500, 30);
	    
	    
		// 학생버튼
		stdButton = new JButton("학생 로그인");
		stdButton.addActionListener( new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	student_page = new Student_page();
                System.out.println(stdButton.getText()+"버튼이 클릭되었습니다.");   
                
            }
            
        });
		
		// 교수버튼
		professorButton = new JButton("교수 로그인");
		professorButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				professor_page =new Professor_page();	
				System.out.println(professorButton.getText() + "버튼이 클릭되었습니다.");
				
			}
		});
		
		c.add(pw_Text);
		c.add(id_Text);
		c.add(stdButton);
		c.add(professorButton);
		
		// 창을 보이게한다
		setVisible(true);
	}
	
}