package Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GUI.Alarm;
import Service.DB.CRUD.Student_All_Info_CRUD;
import Service.Info.Student_All_Info;
import ServiceDBConnection.DB_ConnectionClass;

public class Student_DB extends DB_ConnectionClass implements Student_All_Info_CRUD{
	private Alarm alarm;
	public Student_All_Info allInfo = new Student_All_Info();

	@Override
	public void infoCreate(String id, int point) {
		System.out.println("�л��� ������ �� �����");
		
	}

	@Override
	public void infoDelect(String id) {
		System.out.println("�л��� ������ �� �����");
		
	}

	@Override
	public void infoRead() {
		System.out.println("�л��� ��� �л������� �� �� �����");
		
	}

	@Override
	public void infoUpdate(String whereChange, String changeValue, String id) {
		System.out.println("�л��� ���� ������ �����");
		
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
	            if(rs.next()) {
	            	allInfo.setId(rs.getString("id"));
					allInfo.setNumber(rs.getInt("number"));
					allInfo.setName(rs.getString("name"));
					allInfo.setAge(rs.getInt("age"));
					allInfo.setSex(rs.getString("sex"));
					allInfo.setMajor(rs.getString("major"));
					allInfo.setPoint(rs.getInt("point"));	
					
					alarm = new Alarm("�л������� ������ �Ծ��"+"\n"+
							"id : " + allInfo.getId()+"\n"+
							"�й� : " + allInfo.getNumber()+"\n"+
							"�̸� : " + allInfo.getName()+"\n"+
							"���� : " + allInfo.getAge()+"\n"+
							"���� : " + allInfo.getSex()+"\n"+
							"���� : " + allInfo.getMajor()+"\n"+
							"���� :" + allInfo.getPoint()+"\n"
							);
	            }else {
	            	alarm = new Alarm("�������� �ʴ� �л��Դϴ�. ����� �ּ���");
	            }
	     
	        } catch (Exception e) {
	            System.out.println("select �޼��� ���ܹ߻�");
	        }    finally {
	            try {
	                if(pstmt!=null && !pstmt.isClosed()) {
	                    pstmt.close();
	                }
	            } catch (Exception e2) {}
	        }
		}

}
