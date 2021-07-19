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
		setTitle("���� �������Դϴ�");
		setSize(1000,500);
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		id_Text = new JTextField("���⿡ �л� ID �Է����ּ���");
		point_Text = new JTextField("���⿡ �л� ���� �Է����ּ���");
		findOneStudent = new JTextField("ã������ �л��� id�� �Է����ּ���");
		updatewhereChange = new JTextField("�������� �����ұ��?");
		updatevalue = new JTextField("������� �����ұ��?");
		updateid = new JTextField("�����Ϸ��� �л� id�� �Է��ϼ���,");
		deleteid = new JTextField("������ id�� �Է��ϼ���");
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
		
		insertBtn = new JButton("�л����� �Է�");
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
		
		
		findOneBtn = new JButton("�л� ã��");
		c.add(findOneBtn);
		findOneBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String oneStudentId = findOneStudent.getText();
				proFessorDB.selectRead(oneStudentId);
				
			}
		});
		
		allStudentInfoBtn = new JButton("����л� ������ ã�ƿɴϴ�.");
		c.add(allStudentInfoBtn);
		allStudentInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proFessorDB.infoRead();
				
			}
		});
		
		updateBtn = new JButton("�л����� ������ư");
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
		
		deleteBtn = new JButton("�л����� ���� ��ư");
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