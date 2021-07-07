package Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Service.CRUD;
import Service.DB_ConnectionClass;
import Service.Info;

public class DB extends DB_ConnectionClass implements CRUD{
	
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
	public void infoDelect() {
		// TODO Auto-generated method stub
		
	}

	// ����л����� ��������
	@Override
	public void infoRead() {
		// TODO Auto-generated method stub
		
	}

	//�л����� ����
	@Override
	public void infoUpdate() {
		// TODO Auto-generated method stub
		
	}
    
}
