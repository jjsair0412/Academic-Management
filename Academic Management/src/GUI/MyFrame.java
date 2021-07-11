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
		setTitle("학사정보 시스템"); 
		setSize(1000,500); 
		// 종료버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
	    
		id_Text = new JTextField("여기에 ID 입력해주세요");
		id_Text.setBounds(10, 50, 2500, 30);
		c.add(id_Text);
		
		
		pw_Text = new JTextField("여기에 pwd 입력해주세요");
		pw_Text.setBounds(10, 50, 2500, 30);
	    c.add(pw_Text);
	    
	   
		
		// 학생버튼
		stdButton = new JButton("학생 로그인");
		stdButton.addActionListener( new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
            	student_page = new Student_page();
                System.out.println(stdButton.getText()+"버튼이 클릭되었습니다.");   
                
            }
            
        });
		
		// 교수 Table에서 id값과 pw값만 꺼내와서 proIdlist에 저장
		ArrayList<String> proIdlist = professor_DB.getProfessorId();
		ArrayList<Integer> proPwlist = professor_DB.getProfessorPw();
		
		// 교수버튼
		professorButton = new JButton("교수 로그인");
		professorButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				String nowId = id_Text.getText();
				int nowPw = Integer.parseInt(pw_Text.getText());
				if(proIdlist.contains(nowId) && proPwlist.contains(nowPw)) {
					professor_page =new Professor_page();	
					System.out.println("로그인 성공");
						
				}else if(proIdlist.contains(nowId) || proPwlist.contains(nowPw)){
					System.out.println("pw나 id를 잘못 입력하셨습니다.");
				}else {
					System.out.println("해당 회원이 없습니다.회원가입을 진행해 주세요.");
				}
				
			}
		});
		
		// 회원가입 버튼
		ProjoinButton = new JButton("교수 회원가입");
		ProjoinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				professorJoin = new ProfessorJoin();
				
			}
		});
		
		StujoinButton = new JButton("학생 회원가입");
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
		
		// 창을 보이게한다
		setVisible(true);
	}
	
}