package Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Service.DB.CRUD.Student_join_CRUD;
import Service.Info.StudentIdPw_info;
import ServiceDBConnection.DB_ConnectionClass;

public class Student_Join extends DB_ConnectionClass implements Student_join_CRUD{

	public static ArrayList<String> StuId = new ArrayList<String>();
    public static ArrayList<Integer> StuPw = new ArrayList<Integer>();
	private StudentIdPw_info studentIdPw_info = new StudentIdPw_info();
    
	@Override
	public void Create(String id, int number, String name, int age, String sex, String major, int StdPw) {
		//������ �غ�
        String sql = "insert into std_join values(?,?,?,?,?,?,?)";
        
        // Sql������ �������ִ� PreparedStatement Ŭ���� ��ü����
        PreparedStatement pstmt = null;
        try {
        	// ���ڰ����� �ۼ����־��� sql������ �־��ش�.
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setInt(2, number);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, sex);
            pstmt.setString(6, major);
            pstmt.setInt(7, StdPw);
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("ȸ������ �Ϸ�");
            }
        } catch (Exception e) {
            System.out.println("�̹� �����ϴ� ID�Դϴ�. �ٽ� �ۼ����ּ���.");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
        
		
	}

	@Override
	public  ArrayList<String> getStudentId() {
		// id���� ���ؼ� ���� id�� ��θ� �������
        String sql = "select id from std_join";
        PreparedStatement pstmt = null;
        try {
            pstmt = getConn().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	studentIdPw_info.setId(rs.getString("id"));
                StuId.add(studentIdPw_info.getId());
            }else {
            	System.out.println("");
            }
     
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("getStudentId() �޼��� ���ܹ߻�");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
		return StuId;
		
	}

	@Override
	public ArrayList<Integer> getStudentPw() {
		// id���� ���ؼ� ���� password�� ��θ� �������
        String sql = "select StdPw from std_join";
        PreparedStatement pstmt = null;
        try {
            pstmt = getConn().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	studentIdPw_info.setPw(rs.getInt("StdPw"));
                StuPw.add(studentIdPw_info.getPw());
            }else {
            	System.out.println("");
            }
     
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("getStudentPw() �޼��� ���ܹ߻�");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
		
		return StuPw;
	}
		
		
}


