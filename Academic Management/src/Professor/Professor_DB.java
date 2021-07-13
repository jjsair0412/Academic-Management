package Professor;

import java.awt.Graphics;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import GUI.Alarm;
import Service.DB.CRUD.Student_All_Info_CRUD;
import Service.Info.Student_All_Info;
import ServiceDBConnection.DB_ConnectionClass;

public class Professor_DB extends DB_ConnectionClass implements Student_All_Info_CRUD {

	private Alarm alarm;
	public Student_All_Info allInfo = new Student_All_Info();
	
	// �л����� �Է�
	@Override
	public void infoCreate(String id, int point) {
		// ������ �غ�
		String sql = "update info set point = ? where id = ?";
		// Sql������ �������ִ� PreparedStatement Ŭ���� ��ü����
		PreparedStatement pstmt = null;
		try {
			// ���ڰ����� �ۼ����־��� sql������ �־��ش�.
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				alarm = new Alarm("�л����� �Է� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
			alarm = new Alarm("�л����� �Է� ����");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}

	// �л����� ����
	@Override
	public void infoDelect(String id) {
		String sql = "delete from info where id = ?";

		// Sql������ �������ִ� PreparedStatement Ŭ���� ��ü����
		PreparedStatement pstmt = null;
		try {
			// ���ڰ����� �ۼ����־��� sql������ �־��ش�.
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				alarm = new Alarm("�л����� ���� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
			alarm = new Alarm("�л����� ���� ����");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}

	// ����л����� ��������
	@Override
	public void infoRead() {
		// ����л� ���� �������
		String sql = "select * from info ";
		PreparedStatement pstmt = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allInfo.setId(rs.getString("id"));
				allInfo.setNumber(rs.getInt("number"));
				allInfo.setName(rs.getString("name"));
				allInfo.setAge(rs.getInt("age"));
				allInfo.setSex(rs.getString("sex"));
				allInfo.setMajor(rs.getString("major"));
				allInfo.setPoint(rs.getInt("point"));		
				
			}
			alarm = new Alarm("�л������� ������ �Ծ��"+"\n"+
					"id : " + allInfo.getId()+"\n"+
					"�й� : " + allInfo.getNumber()+"\n"+
					"�̸� : " + allInfo.getName()+"\n"+
					"���� : " + allInfo.getAge()+"\n"+
					"���� : " + allInfo.getSex()+"\n"+
					"���� : " + allInfo.getMajor()+"\n"+
					"���� :" + allInfo.getPoint()+"\n"
					);
		} catch (Exception e) {
			System.out.println("select �޼��� ���ܹ߻�");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	// �л����� ����
	@Override
	public void infoUpdate(String id, String whereChange, String changeValue) {
		// �޾ƿ� id���� �л��� ������

		// Sql������ �������ִ� PreparedStatement Ŭ���� ��ü����
		PreparedStatement pstmt = null;
		try {
			// ���ڰ����� �ۼ����־��� sql������ �־��ش�.
			// number�ϰ��� age�ϰ��, ���ε��� sql������ �ۼ����� ������
			// setString���� db�� ���۵Ǵ� ���� 'string��' �̷��� ���� ������
			// db�� ������������ ������ ����.
			// ���� sql������ ���� �ۼ��� �ش� ������ �ذ��ߴ�.
			if (whereChange.equals("number")) {
				String Numbersql = "update info set number = ? where id=?";
				pstmt = getConn().prepareStatement(Numbersql);
				pstmt.setInt(1, Integer.parseInt(changeValue));
				pstmt.setString(2, id);
			} else if ((whereChange.equals("name"))) {
				String Namesql = "update info set name = ? where id=?";
				pstmt = getConn().prepareStatement(Namesql);
				pstmt.setString(1, changeValue);
				pstmt.setString(2, id);
			} else if ((whereChange.equals("age"))) {
				String Agesql = "update info set age = ? where id=?";
				pstmt = getConn().prepareStatement(Agesql);
				pstmt.setInt(1, Integer.parseInt(changeValue));
				pstmt.setString(2, id);
			} else if ((whereChange.equals("sex"))) {
				String Sexsql = "update info set sex = ? where id=?";
				pstmt = getConn().prepareStatement(Sexsql);
				pstmt.setString(1, changeValue);
				pstmt.setString(2, id);
			} else if ((whereChange.equals("major"))) {
				String Majorsql = "update info set major = ? where id=?";
				pstmt = getConn().prepareStatement(Majorsql);
				pstmt.setString(1, changeValue);
				pstmt.setString(2, id);
			} else if ((whereChange.equals("point"))) {
				String Pointsql = "update info set point = ? where id=?";
				pstmt = getConn().prepareStatement(Pointsql);
				pstmt.setInt(1, Integer.parseInt(changeValue));
				pstmt.setString(2, id);
			} else {
				alarm = new Alarm("id�� ������ �� �����ϴ�.");
			}

			int result = pstmt.executeUpdate();

			if (result == 1) {
				alarm = new Alarm("���� ����.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Է� ����");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}

	}

	// �Ѹ��� �л����� ���������
	@Override
	public void selectRead(String id) {
		// id���� ���ؼ� ���� id�� �Ѱ����� �������
		String sql = "select * from info where id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				alarm = new Alarm("��ȸ�� �л����� : "+"\n"+
						"id : " + rs.getString("id")+"\n"+
						"�й� : " + rs.getString("number")+"\n"+
						"�̸� : " + rs.getString("name")+"\n"+
						"���� : " + rs.getString("age")+"\n"+
						"���� : " + rs.getString("sex")+"\n"+
						"���� : " + rs.getString("major")+"\n"+
						"���� :" + rs.getString("point")
						);
				
			} else {
				alarm = new Alarm("�������� �ʴ� �л��Դϴ�. ������ּ���");
			}

		} catch (Exception e) {
			System.out.println("select �޼��� ���ܹ߻�");
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e2) {
			}
		}
	}


}
