package JoinGUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Service.Info.Student_Join_info;
import Student.Student_Join;

public class StudentJoinPage extends JFrame{
	private JTextField idText, nameText, numberText, ageText, sexText, majorText, spwText;
	private Student_Join studentJoin = new Student_Join();
	private Student_Join_info student_Join_info = new Student_Join_info();
	JButton JoinBtn;
	
	
	public StudentJoinPage() {
		setTitle("학생 회원가입창 입니다."); 
		setSize(1000,500); 
		
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		idText = new JTextField("id 입력해주세요");
		numberText = new JTextField("학번 입력해주세요");	
		nameText = new JTextField("이름 입력해주세요");
		ageText = new JTextField("나이 입력해주세요");
		sexText = new JTextField("성별 입력해주세요");
		majorText = new JTextField("전공 입력해주세요");
		spwText = new JTextField("비밀번호 입력해 주세요");
		
		JTextField[] textField = {
				idText, 
				numberText,
				nameText, 
				ageText, 
				sexText, 
				majorText, 
				spwText
				};
		
		for(int i = 0; i<textField.length; i++) {
			c.add(textField[i]);
		}
		
		JoinBtn = new JButton("회원가입 버튼");
		c.add(JoinBtn);
		JoinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				student_Join_info.setId(idText.getText());
				student_Join_info.setNumber(Integer.parseInt(numberText.getText()));
				student_Join_info.setName(nameText.getText());
				student_Join_info.setAge(Integer.parseInt(ageText.getText()));
				student_Join_info.setSex(sexText.getText());
				student_Join_info.setMajor(majorText.getText());
				student_Join_info.setStdPw(Integer.parseInt(spwText.getText()));
				
				studentJoin.Create(
						student_Join_info.getId(),
						student_Join_info.getNumber(),
						student_Join_info.getName(),
						student_Join_info.getAge(),
						student_Join_info.getSex(),
						student_Join_info.getMajor(),
						student_Join_info.getStdPw()
						);
				
			}
		});
		
		
		setVisible(true);
	}

}
