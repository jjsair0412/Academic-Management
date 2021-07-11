package Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Service.DB.CRUD.Student_All_Info_CRUD;
import ServiceDBConnection.DB_ConnectionClass;

public class Student_DB extends DB_ConnectionClass implements Student_All_Info_CRUD{

	@Override
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point) {
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
	                System.out.println("id : " + rs.getString("id"));
	                System.out.println("number : " + rs.getString("number"));
	                System.out.println("name : " + rs.getString("name"));
	                System.out.println("age : " + rs.getString("age"));
	                System.out.println("sex : " + rs.getString("sex"));
	                System.out.println("major : " + rs.getString("major"));
	                System.out.println("point :"+rs.getString("point"));
	            }else {
	            	System.out.println("�������� �ʴ� �л��Դϴ�. ������ּ���");
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
