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
		setTitle("�л����� �ý���");
		setSize(1000, 500);
		// �����ư
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		id_Text = new JTextField("���⿡ ID �Է����ּ���");
		id_Text.setBounds(10, 50, 2500, 30);
		c.add(id_Text);

		pw_Text = new JTextField("���⿡ pwd �Է����ּ���");
		pw_Text.setBounds(10, 50, 2500, 30);
		c.add(pw_Text);
		
		

		// �л���ư
		stdButton = new JButton("�л� �α���");
		stdButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// �л� Table���� id���� pw���� �����ͼ� proIdlist�� ����
				ArrayList<String> stuIdlist = new ArrayList<String>();
				ArrayList<Integer> stuPwlist = new ArrayList<Integer>();
				
				stuIdlist = student_Join.getStudentId();
				stuPwlist = student_Join.getStudentPw();

				nowId = id_Text.getText();
				nowPw = Integer.parseInt(pw_Text.getText());
				
				if (stuIdlist.contains(nowId) && stuPwlist.contains(nowPw)) {
					alarm = new Alarm("�α��� ����");
					student_page = new Student_page(nowId);

				} else if (stuIdlist.contains(nowId) || stuPwlist.contains(nowPw)) {
					alarm = new Alarm("Id�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				} else {
					alarm = new Alarm("�ش� ȸ���� �����. ȸ�������� ������ �ּ���");
				}

			}

		});

		// ������ư
		professorButton = new JButton("���� �α���");
		professorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> proIdlist = new ArrayList<String>();
				ArrayList<Integer> proPwlist = new ArrayList<Integer>();

				// ���� Table���� id���� pw���� �����ͼ� proIdlist�� ����
				proIdlist = professor_Join.getProfessorId();
				proPwlist = professor_Join.getProfessorPw();

				nowId = id_Text.getText();
				nowPw = Integer.parseInt(pw_Text.getText());
				
				if (proIdlist.contains(nowId) && proPwlist.contains(nowPw)) {
					alarm = new Alarm("�α��� ����");
					professor_page = new Professor_page();
					

				} else if (proIdlist.contains(nowId) || proPwlist.contains(nowPw)) {
					alarm = new Alarm("Id�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				} else {
					alarm = new Alarm("�ش� ȸ���� �����. ȸ�������� ������ �ּ���");
				}

			}
		});

		// ȸ������ ��ư
		ProjoinButton = new JButton("���� ȸ������");
		ProjoinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				professorJoin = new ProfessorJoinPage();

			}
		});

		StujoinButton = new JButton("�л� ȸ������");
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

		// â�� ���̰��Ѵ�
		setVisible(true);
	}

}