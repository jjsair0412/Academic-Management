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
	            	allInfo.setId(rs.getString("id"));
					allInfo.setNumber(rs.getInt("number"));
					allInfo.setName(rs.getString("name"));
					allInfo.setAge(rs.getInt("age"));
					allInfo.setSex(rs.getString("sex"));
					allInfo.setMajor(rs.getString("major"));
					allInfo.setPoint(rs.getInt("point"));	
					
					alarm = new Alarm("학생정보를 가지고 왔어요"+"\n"+
							"id : " + allInfo.getId()+"\n"+
							"학번 : " + allInfo.getNumber()+"\n"+
							"이름 : " + allInfo.getName()+"\n"+
							"나이 : " + allInfo.getAge()+"\n"+
							"성별 : " + allInfo.getSex()+"\n"+
							"전공 : " + allInfo.getMajor()+"\n"+
							"점수 :" + allInfo.getPoint()+"\n"
							);
	            }else {
	            	alarm = new Alarm("존재하지 않는 학생입니다. 등록해 주세요");
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
