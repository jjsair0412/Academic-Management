package Professor;

import java.sql.PreparedStatement;

import Service.DB.CRUD.Professor_join_CRUD;
import ServiceDBConnection.DB_ConnectionClass;

public class Professor_Join extends DB_ConnectionClass implements Professor_join_CRUD{

	// ȸ������
	@Override
	public void Create(String id, String name, int age, String sex, String major, int proPw) {
		//������ �غ�
        String sql = "insert into professor_join values(?,?,?,?,?,?)";
        
        // Sql������ �������ִ� PreparedStatement Ŭ���� ��ü����
        PreparedStatement pstmt = null;
        try {
        	// ���ڰ����� �ۼ����־��� sql������ �־��ش�.
            pstmt = getConn().prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, sex);
            pstmt.setString(5, major);
            pstmt.setInt(6, proPw);
            
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

	// �ڱ����� ����
	@Override
	public void Read() {
		// TODO Auto-generated method stub
		
	}

	// ��������
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}
	
	// ȸ��Ż��
	@Override
	public void Drop() {
		// TODO Auto-generated method stub
		
	}


}
