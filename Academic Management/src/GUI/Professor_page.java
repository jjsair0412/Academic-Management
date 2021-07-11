package GUI;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Professor.Professor_DB;
import Service.Info.Student_All_Info;
import ServiceDBConnection.DB_ConnectionClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Professor_page extends JFrame{
	private Professor_DB proFessorDB = new Professor_DB();
	private Student_All_Info info = new Student_All_Info();
	private JTextField id_Text, number_Text, name_Text, age_Text, 
	sex_Text, major_Text, point_Text, findOneStudent, 
	updatewhereChange, updatevalue, updateid, deleteid= null;
	JButton insertBtn, findOneBtn, allStudentInfoBtn, updateBtn, deleteBtn;
	
	public Professor_page() {
		setTitle("교수 페이지입니다");
		setSize(1000,500);
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		id_Text = new JTextField("여기에 학생 ID 입력해주세요");
		number_Text = new JTextField("여기에 학생 학번 입력해주세요");
		name_Text = new JTextField("여기에 학생 이름 입력해주세요");
		age_Text = new JTextField("여기에 학생 나이 입력해주세요");
		sex_Text = new JTextField("여기에 학생 성별 입력해주세요");
		major_Text = new JTextField("여기에 학생 전공 입력해주세요");
		point_Text = new JTextField("여기에 학생 점수 입력해주세요");
		findOneStudent = new JTextField("찾으려는 학생의 id를 입력해주세요");
		updatewhereChange = new JTextField("무슨값을 변경할까요?");
		updatevalue = new JTextField("어떤값으로 변경할까요?");
		updateid = new JTextField("수정하려면 학생 id를 입력하세요,");
		deleteid = new JTextField("삭제할 id를 입력하세요");
		
		JTextField[] textFiled = {
				id_Text, 
				number_Text,
				name_Text,
				age_Text,
				sex_Text,
				major_Text,
				point_Text,
				findOneStudent,
				updatewhereChange,
				updatevalue,
				updateid,
				deleteid
				};
		
		for(int i = 0; i<textFiled.length; i++) {
			c.add(textFiled[i]);
		}
		
		insertBtn = new JButton("학생정보 입력");
		c.add(insertBtn);
		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				info.setId(id_Text.getText());
				info.setNumber(Integer.parseInt(number_Text.getText()));
				info.setName(name_Text.getText()); 
				info.setAge(Integer.parseInt(age_Text.getText()));
				info.setSex(sex_Text.getText());
				info.setMajor(major_Text.getText());
				info.setPoint(Integer.parseInt(point_Text.getText()));
				
				proFessorDB.infoCreate(
						info.getId(), 
						info.getNumber(), 
						info.getName(), 
						info.getAge(), 
						info.getSex(), 
						info.getMajor(), 
						info.getPoint()
						);
			}
		});
		
		
		findOneBtn = new JButton("학생 찾기");
		c.add(findOneBtn);
		findOneBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String oneStudentId = findOneStudent.getText();
				proFessorDB.selectRead(oneStudentId);
				
			}
		});
		
		allStudentInfoBtn = new JButton("모든학생 정보를 찾아옵니다.");
		c.add(allStudentInfoBtn);
		allStudentInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proFessorDB.infoRead();
				
			}
		});
		
		updateBtn = new JButton("학생정보 수정버튼");
		c.add(updateBtn);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String updateI = updateid.getText();
				String updateC = updatewhereChange.getText();
				String updateV = updatevalue.getText();
				proFessorDB.infoUpdate(updateI,updateC ,updateV);
				proFessorDB.infoRead();
			}
		});
		
		deleteBtn = new JButton("학생정보 삭제 버튼");
		c.add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String deid = deleteid.getText();
				proFessorDB.infoDelect(deid);
			
			}
		});
		
		setVisible(true);
	}

}