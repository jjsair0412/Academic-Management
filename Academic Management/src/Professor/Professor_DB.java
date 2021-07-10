package Professor;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


import Service.CRUD;
import Service.DB_ConnectionClass;

public class Professor_DB extends DB_ConnectionClass implements CRUD{

    // �л����� �Է�
	@Override
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point) {	
		//������ �غ�
        String sql = "insert into info values(?,?,?,?,?,?,?)";
        
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
            pstmt.setInt(7, point);
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("�л����� �Է� ����");
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("�Է� ����");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
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
            
            if(result==1) {
                System.out.println("���� ����");
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("�Է� ����");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
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
            System.out.println("select �޼��� ���ܹ߻�");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
	}

	//�л����� ����
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
            	System.out.println("id�� ������ �� �����ϴ�.");
            }
            
            
            int result = pstmt.executeUpdate();
            
            if(result==1) {
                System.out.println("���� ����");
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("�Է� ����");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
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
