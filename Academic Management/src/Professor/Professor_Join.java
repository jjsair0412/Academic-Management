package Professor;

import java.sql.PreparedStatement;

import Service.DB.CRUD.Professor_join_CRUD;
import ServiceDBConnection.DB_ConnectionClass;

public class Professor_Join extends DB_ConnectionClass implements Professor_join_CRUD{

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
                System.out.println("회원가입 완료");
            }
        } catch (Exception e) {
            System.out.println("이미 존재하는 ID입니다. 다시 작성해주세요.");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
        
		
	}

	// 자기정보 보기
	@Override
	public void Read() {
		// TODO Auto-generated method stub
		
	}

	// 정보수정
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	// 회원탈퇴
	@Override
	public void Drop() {
		// TODO Auto-generated method stub
		
	}


}
