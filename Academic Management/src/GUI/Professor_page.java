package GUI;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Professor.Professor_DB;
import Service.Info.Student_All_Info;
import ServiceDBConnection.DB_ConnectionClass;
import SocketConnection.ProfessorClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Professor_page extends JFrame{
	private Professor_DB proFessorDB = new Professor_DB();
	private Student_All_Info info = new Student_All_Info();
	private JTextField id_Text, point_Text, findOneStudent, 
	updatewhereChange, updatevalue, updateid, deleteid= null;
	private JButton insertBtn, findOneBtn, allStudentInfoBtn, updateBtn, deleteBtn;
	private ProfessorClient professorClient = new ProfessorClient();
	
	public Professor_page() {
		setTitle("교수 페이지입니다");
		setSize(1000,500);
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		id_Text = new JTextField("여기에 학생 ID 입력해주세요");
		point_Text = new JTextField("여기에 학생 점수 입력해주세요");
		findOneStudent = new JTextField("찾으려는 학생의 id를 입력해주세요");
		updatewhereChange = new JTextField("무슨값을 변경할까요?");
		updatevalue = new JTextField("어떤값으로 변경할까요?");
		updateid = new JTextField("수정하려면 학생 id를 입력하세요,");
		deleteid = new JTextField("삭제할 id를 입력하세요");
		JTextField[] textFiled = {
				id_Text, 
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
		
		insertBtn = new JButton("학생점수 입력");
		c.add(insertBtn);
		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				info.setId(id_Text.getText());
				info.setPoint(Integer.parseInt(point_Text.getText()));
				
				proFessorDB.infoCreate(
						info.getId(), 
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