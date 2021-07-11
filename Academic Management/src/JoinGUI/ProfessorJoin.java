package JoinGUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Professor.Professor_Join;
import Service.Info.Professor_Join_info;

public class ProfessorJoin extends JFrame {
	private JTextField idText, nameText, ageText, sexText, majorText, pwText= null;
	private Professor_Join professor_Join = new Professor_Join();
	private Professor_Join_info professor_Join_info = new Professor_Join_info();
	JButton JoinBtn, CheckBtn, UpdateBtn, DropBtn; 
	
	public ProfessorJoin() {
		setTitle("���� ȸ������â �Դϴ�."); 
		setSize(1000,500); 
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		idText = new JTextField("id �Է����ּ���");
		nameText = new JTextField("�̸� �Է����ּ���");
		ageText = new JTextField("���� �Է����ּ���");
		sexText = new JTextField("���� �Է����ּ���");
		majorText = new JTextField("���� �Է����ּ���");
		pwText = new JTextField("��й�ȣ �Է��� �ּ���");
	
		
		JTextField[] textFiled = {
				idText, 
				nameText, 
				ageText, 
				sexText, 
				majorText, 
				pwText
				};
		
		for(int i = 0; i<textFiled.length; i++) {
			c.add(textFiled[i]);
		}
		
		
			JoinBtn = new JButton("ȸ������ ��ư");
			c.add(JoinBtn);
			JoinBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					professor_Join_info.setId(idText.getText());
					professor_Join_info.setName(nameText.getText());
					professor_Join_info.setAge(Integer.parseInt(ageText.getText()));
					professor_Join_info.setSex(sexText.getText());
					professor_Join_info.setMajor(majorText.getText());
					professor_Join_info.setProPw(Integer.parseInt(pwText.getText()));
					
					professor_Join.Create(
							professor_Join_info.getId(), 
							professor_Join_info.getName(), 
							professor_Join_info.getAge(), 
							professor_Join_info.getSex(), 
							professor_Join_info.getMajor(), 
							professor_Join_info.getProPw()
							);
				}
			});	
			
		setVisible(true);
	}
}
