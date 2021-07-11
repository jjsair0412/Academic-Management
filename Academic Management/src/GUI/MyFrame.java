package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.*;

import JoinGUI.ProfessorJoin;
import JoinGUI.StudentJoin;
import Professor.Professor_DB;

public class MyFrame extends JFrame{
	JButton stdButton, professorButton, ProjoinButton, StujoinButton;
	Student_page student_page;
	Professor_page professor_page;
	StudentJoin studentJoin;
	ProfessorJoin professorJoin;
	JTextField id_Text, pw_Text;
	Professor_DB professor_DB = new Professor_DB();
	public MyFrame() {
		setTitle("�л����� �ý���"); 
		setSize(1000,500); 
		// �����ư
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
	    
		id_Text = new JTextField("���⿡ ID �Է����ּ���");
		id_Text.setBounds(10, 50, 2500, 30);
		c.add(id_Text);
		
		
		pw_Text = new JTextField("���⿡ pwd �Է����ּ���");
		pw_Text.setBounds(10, 50, 2500, 30);
	    c.add(pw_Text);
	    
	   
		
		// �л���ư
		stdButton = new JButton("�л� �α���");
		stdButton.addActionListener( new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	student_page = new Student_page();
                System.out.println(stdButton.getText()+"��ư�� Ŭ���Ǿ����ϴ�.");   
                
            }
            
        });
		
		// ���� Table���� id���� pw���� �����ͼ� proIdlist�� ����
		ArrayList<String> proIdlist = professor_DB.getProfessorId();
		ArrayList<Integer> proPwlist = professor_DB.getProfessorPw();
		
		// ������ư
		professorButton = new JButton("���� �α���");
		professorButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				String nowId = id_Text.getText();
				int nowPw = Integer.parseInt(pw_Text.getText());
				if(proIdlist.contains(nowId) && proPwlist.contains(nowPw)) {
					professor_page =new Professor_page();	
					System.out.println("�α��� ����");
						
				}else if(proIdlist.contains(nowId) || proPwlist.contains(nowPw)){
					System.out.println("pw�� id�� �߸� �Է��ϼ̽��ϴ�.");
				}else {
					System.out.println("�ش� ȸ���� �����ϴ�.ȸ�������� ������ �ּ���.");
				}
				
			}
		});
		
		// ȸ������ ��ư
		ProjoinButton = new JButton("���� ȸ������");
		ProjoinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				professorJoin = new ProfessorJoin();
				
			}
		});
		
		StujoinButton = new JButton("�л� ȸ������");
		StujoinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentJoin = new StudentJoin();
				
			}
		});
		

		JButton[] jbutton = {stdButton, professorButton, ProjoinButton, StujoinButton};
		for(int i = 0; i<jbutton.length; i++) {
			c.add(jbutton[i]);
		}
		
		// â�� ���̰��Ѵ�
		setVisible(true);
	}
	
}