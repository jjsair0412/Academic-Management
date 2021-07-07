package Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Service.CRUD;
import Service.DB_ConnectionClass;
import Service.Info;

public class DB extends DB_ConnectionClass implements CRUD{
	
    // 학생정보 입력
	@Override
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point) {	
		//쿼리문 준비
        String sql = "insert into info values(?,?,?,?,?,?,?)";
        
        // Sql구문을 실행해주는 PreparedStatement 클래스 객체생성
        PreparedStatement pstmt = null;
        try {
        	// 인자값으로 작성해주었던 sql구문을 넣어준다.
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setInt(2, number);
            pstmt.setString(3, name);
            pstmt.setInt(4, age);
            pstmt.setString(5, sex);
            pstmt.setString(6, major);
            pstmt.setInt(7, point);
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("학생정보 입력 성공");
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("입력 실패");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
        
        
    }    
		

	// 학생정보 삭제
	@Override
	public void infoDelect() {
		// TODO Auto-generated method stub
		
	}

	// 모든학생정보 가져오기
	@Override
	public void infoRead() {
		// TODO Auto-generated method stub
		
	}

	//학생정보 수정
	@Override
	public void infoUpdate() {
		// TODO Auto-generated method stub
		
	}
    
}
