package Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Service.DB.CRUD.Student_All_Info_CRUD;
import ServiceDBConnection.DB_ConnectionClass;

public class Student_DB extends DB_ConnectionClass implements Student_All_Info_CRUD{

	@Override
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point) {
		System.out.println("학생은 변경할 수 없어요");
		
	}

	@Override
	public void infoDelect(String id) {
		System.out.println("학생은 삭제할 수 없어요");
		
	}

	@Override
	public void infoRead() {
		System.out.println("학생은 모든 학생정보를 볼 수 없어요");
		
	}

	@Override
	public void infoUpdate(String whereChange, String changeValue, String id) {
		System.out.println("학생은 수정 권한이 없어요");
		
	}

	// 한명의 학생정보 가지고오기
		@Override
		public void selectRead(String id) {
			// id값을 비교해서 비교한 id값 한가지를 가지고옴
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
	            	System.out.println("존재하지 않는 학생입니다. 등록해주세요");
	            }
	     
	        } catch (Exception e) {
	            System.out.println("select 메서드 예외발생");
	        }    finally {
	            try {
	                if(pstmt!=null && !pstmt.isClosed()) {
	                    pstmt.close();
	                }
	            } catch (Exception e2) {}
	        }
		}

}
