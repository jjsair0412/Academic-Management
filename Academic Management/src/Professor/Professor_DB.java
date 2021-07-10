package Professor;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


import Service.CRUD;
import Service.DB_ConnectionClass;

public class Professor_DB extends DB_ConnectionClass implements CRUD{

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
	public void infoDelect(String id) {
		String sql = "delete from info where id = ?";

        // Sql구문을 실행해주는 PreparedStatement 클래스 객체생성
        PreparedStatement pstmt = null;
        try {
        	// 인자값으로 작성해주었던 sql구문을 넣어준다.
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1, id);
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("삭제 성공");
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

	// 모든학생정보 가져오기
	@Override
	public void infoRead() {
		// 모든학생 정보 가지고옴
        String sql = "select * from info ";
        PreparedStatement pstmt = null;
        try {
            pstmt = getConn().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println("id : " + rs.getString("id"));
                System.out.println("number : " + rs.getString("number"));
                System.out.println("name : " + rs.getString("name"));
                System.out.println("age : " + rs.getString("age"));
                System.out.println("sex : " + rs.getString("sex"));
                System.out.println("major : " + rs.getString("major"));
                System.out.println("point :"+rs.getString("point"));
                System.out.printf("\n");
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

	//학생정보 수정
	@Override
	public void infoUpdate(String id, String whereChange, String changeValue) {
		// 받아온 id값의 학생을 수정함
        
		// Sql구문을 실행해주는 PreparedStatement 클래스 객체생성
        PreparedStatement pstmt = null;
        try {
        	// 인자값으로 작성해주었던 sql구문을 넣어준다.
            // number일경우와 age일경우, 따로따로 sql구문을 작성해준 이유는 
        	// setString으로 db에 전송되는 값이 'string값' 이렇게 가기 때문에 
        	// db의 쿼리구문에서 오류가 난다.
        	// 따라서 sql구문을 따로 작성해 해당 오류를 해결했다.
            if(whereChange.equals("number")) {
            	String Numbersql = "update info set number = ? where id=?";
                pstmt = getConn().prepareStatement(Numbersql);        
            	pstmt.setInt(1, Integer.parseInt(changeValue));
            	pstmt.setString(2, id);
            }else if((whereChange.equals("name"))){
            	String Namesql = "update info set name = ? where id=?";
            	pstmt = getConn().prepareStatement(Namesql);     
            	pstmt.setString(1, changeValue);
            	pstmt.setString(2, id);
            }else if((whereChange.equals("age"))){
            	String Agesql = "update info set age = ? where id=?";
            	pstmt = getConn().prepareStatement(Agesql);     
            	pstmt.setInt(1, Integer.parseInt(changeValue));
            	pstmt.setString(2, id);
            }else if((whereChange.equals("sex"))){
            	String Sexsql = "update info set sex = ? where id=?";
            	pstmt = getConn().prepareStatement(Sexsql);     
            	pstmt.setString(1, changeValue);
            	pstmt.setString(2, id);
            }else if((whereChange.equals("major"))){
            	String Majorsql = "update info set major = ? where id=?";
            	pstmt = getConn().prepareStatement(Majorsql);     
            	pstmt.setString(1, changeValue);
            	pstmt.setString(2, id);
            }else if((whereChange.equals("point"))){
            	String Pointsql = "update info set point = ? where id=?";
            	pstmt = getConn().prepareStatement(Pointsql);     
            	pstmt.setInt(1, Integer.parseInt(changeValue));
            	pstmt.setString(2, id);
            }else {
            	System.out.println("id는 변경할 수 없습니다.");
            }
            
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("수정 성공");
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
