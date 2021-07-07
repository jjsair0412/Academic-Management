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
		setTitle("�л����� �ý���"); 
		setSize(1000,500); 
		// �����ư
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		p = new JPanel();
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
	    
		JTextField id_Text = new JTextField("���⿡ ID �Է����ּ���");
		id_Text.setBounds(10, 50, 2500, 30);
		
		JTextField pw_Text = new JTextField("���⿡ pwd �Է����ּ���");
		pw_Text.setBounds(10, 50, 2500, 30);
	    
	    
		// �л���ư
		stdButton = new JButton("�л� �α���");
		stdButton.addActionListener( new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	student_page = new Student_page();
                System.out.println(stdButton.getText()+"��ư�� Ŭ���Ǿ����ϴ�.");   
                
            }
            
        });
		
		// ������ư
		professorButton = new JButton("���� �α���");
		professorButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				professor_page =new Professor_page();	
				System.out.println(professorButton.getText() + "��ư�� Ŭ���Ǿ����ϴ�.");
				
			}
		});
		
		c.add(pw_Text);
		c.add(id_Text);
		c.add(stdButton);
		c.add(professorButton);
		
		// â�� ���̰��Ѵ�
		setVisible(true);
	}
	
}