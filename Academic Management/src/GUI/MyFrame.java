package GUI;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import JoinGUI.ProfessorJoinPage;
import JoinGUI.StudentJoinPage;
import Professor.Professor_Join;
import Student.Student_Join;

public class MyFrame extends JFrame {
	private JButton stdButton, professorButton, ProjoinButton, StujoinButton;
	private JTextField id_Text, pw_Text;
	private Student_page student_page;
	private Professor_page professor_page;
	private StudentJoinPage studentJoin;
	private ProfessorJoinPage professorJoin;
	private Alarm alarm;
	private Professor_Join professor_Join = new Professor_Join();
	private Student_Join student_Join = new Student_Join();
	private String nowId = null;
	private int nowPw = 0;
	
	public MyFrame() {
		setTitle("학사정보 시스템");
		setSize(1000, 500);
		// 종료버튼
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		id_Text = new JTextField("여기에 ID 입력해주세요");
		id_Text.setBounds(10, 50, 2500, 30);
		c.add(id_Text);

		pw_Text = new JTextField("여기에 pwd 입력해주세요");
		pw_Text.setBounds(10, 50, 2500, 30);
		c.add(pw_Text);
		
		

		// 학생버튼
		stdButton = new JButton("학생 로그인");
		stdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 학생 Table에서 id값과 pw값만 꺼내와서 proIdlist에 저장
				ArrayList<String> stuIdlist = new ArrayList<String>();
				ArrayList<Integer> stuPwlist = new ArrayList<Integer>();
				
				stuIdlist = student_Join.getStudentId();
				stuPwlist = student_Join.getStudentPw();

				nowId = id_Text.getText();
				nowPw = Integer.parseInt(pw_Text.getText());
				
				if (stuIdlist.contains(nowId) && stuPwlist.contains(nowPw)) {
					alarm = new Alarm("로그인 성공");
					student_page = new Student_page(nowId);

				} else if (stuIdlist.contains(nowId) || stuPwlist.contains(nowPw)) {
					alarm = new Alarm("Id나 비밀번호를 잘못 입력하셨습니다.");
				} else {
					alarm = new Alarm("해당 회원이 없어요. 회원가입을 진행해 주세요");
				}

			}

		});

		// 교수버튼
		professorButton = new JButton("교수 로그인");
		professorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> proIdlist = new ArrayList<String>();
				ArrayList<Integer> proPwlist = new ArrayList<Integer>();

				// 교수 Table에서 id값과 pw값만 꺼내와서 proIdlist에 저장
				proIdlist = professor_Join.getProfessorId();
				proPwlist = professor_Join.getProfessorPw();

				nowId = id_Text.getText();
				nowPw = Integer.parseInt(pw_Text.getText());
				
				if (proIdlist.contains(nowId) && proPwlist.contains(nowPw)) {
					alarm = new Alarm("로그인 성공");
					professor_page = new Professor_page();
					

				} else if (proIdlist.contains(nowId) || proPwlist.contains(nowPw)) {
					alarm = new Alarm("Id나 비밀번호를 잘못 입력하셨습니다.");
				} else {
					alarm = new Alarm("해당 회원이 없어요. 회원가입을 진행해 주세요");
				}

			}
		});

		// 회원가입 버튼
		ProjoinButton = new JButton("교수 회원가입");
		ProjoinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				professorJoin = new ProfessorJoinPage();

			}
		});

		StujoinButton = new JButton("학생 회원가입");
		StujoinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studentJoin = new StudentJoinPage();

			}
		});

		JButton[] jbutton = { stdButton, professorButton, ProjoinButton, StujoinButton };
		for (int i = 0; i < jbutton.length; i++) {
			c.add(jbutton[i]);
		}

		// 창을 보이게한다
		setVisible(true);
	}

}