package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Professor.DB;
import Service.DB_ConnectionClass;
import Service.Info;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Professor_page extends JFrame{
	DB proFessorDB = new DB();
	Info info = new Info();
	
	public Professor_page() {
		setTitle("교수 페이지입니다");
		setSize(1000,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		JTextField id_Text = new JTextField("여기에 학생 ID 입력해주세요");
		JTextField number_Text = new JTextField("여기에 학생 학번 입력해주세요");
		JTextField name_Text = new JTextField("여기에 학생 이름 입력해주세요");
		JTextField age_Text = new JTextField("여기에 학생 나이 입력해주세요");
		JTextField sex_Text = new JTextField("여기에 학생 성별 입력해주세요");
		JTextField major_Text = new JTextField("여기에 학생 전공 입력해주세요");
		JTextField point_Text = new JTextField("여기에 학생 점수 입력해주세요");
		
		JTextField[] textFiled = {id_Text, number_Text,name_Text,age_Text,sex_Text,major_Text,point_Text};
		
		for(int i = 0; i<textFiled.length; i++) {
			c.add(textFiled[i]);
		}
		
		JButton insertBtn = new JButton();
		c.add(insertBtn);
		
		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				info.setId(id_Text.getText());
				info.setNumber(Integer.parseInt(number_Text.getText()));
				info.setName(name_Text.getText()); 
				info.setSex(sex_Text.getText());
				info.setMajor(major_Text.getText());
				info.setPoint(Integer.parseInt(point_Text.getText()));
				
				proFessorDB.infoCreate(info.getId(), info.getNumber(), info.getName(), info.getAge(), info.getSex(), info.getMajor(), info.getPoint());
			}
		});
		
		setVisible(true);
	}

}
