package Professor;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import GUI.Alarm;
import Service.DB.CRUD.Professor_join_CRUD;
import Service.Info.ProfessorIdPw_info;
import ServiceDBConnection.DB_ConnectionClass;

public class Professor_Join extends DB_ConnectionClass implements Professor_join_CRUD{
	
	 	public static ArrayList<String> ProId = new ArrayList<String>();
	    public static ArrayList<Integer> ProPw = new ArrayList<Integer>();
	    private ProfessorIdPw_info proIdPw = new ProfessorIdPw_info();
	    private Alarm alarm;
		
	    // professor_join Table 에서 id값만 뽑아오는 getProfessorId()
	    @Override
		public ArrayList<String> getProfessorId() {
			// id값을 비교해서 비교한 id값 한가지를 가지고옴
	        String sql = "select id from professor_join";
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = getConn().prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            if(rs.next()) {
	            	proIdPw.setProfid(rs.getString("id"));
	                ProId.add(proIdPw.getProfid());
	            }else {
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
			return ProId;
			
		}
		// professor_join Table pw값만 뽑아오는 getProfessorPw() 
	    @Override
	    public ArrayList<Integer> getProfessorPw() {
			// id값을 비교해서 비교한 id값 한가지를 가지고옴
	        String sql = "select proPw from professor_join";
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = getConn().prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            if(rs.next()) {
	            	proIdPw.setProfPw(rs.getInt("proPw"));
	            	ProPw.add(proIdPw.getProfPw());
	            }else {
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
			return ProPw;
		}
		
	
	// 회원가입
	@Override
	public void Create(String id, String name, int age, String sex, String major, int proPw) {
		//쿼리문 준비
        String sql = "insert into professor_join values(?,?,?,?,?,?)";
        
        // Sql구문을 실행해주는 PreparedStatement 클래스 객체생성
        PreparedStatement pstmt = null;
        try {
        	// 인자값으로 작성해주었던 sql구문을 넣어준다.
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, sex);
            pstmt.setString(5, major);
            pstmt.setInt(6, proPw);
     
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
            	alarm = new Alarm("회원가입 완료");
            }
        } catch (Exception e) {
        	alarm = new Alarm("이미 존재하는 ID입니다. 다시 작성해주세요");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
        
		
	}

}
