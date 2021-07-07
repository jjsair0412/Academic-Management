package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_ConnectionClass {
	private Connection conn; //DB Ŀ�ؼ� ���� ��ü
    private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "pw12";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    // ����� DBMS�̸�,ȣ��Ʈ IP�ּ�:��Ʈ��ȣ/database �̸� ������ �ۼ��Ѵ�
    
    public DB_ConnectionClass() {
        try {
            System.out.println("�����ͺ��̽� ������..");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("����̹� �ε� ����");
        } catch (Exception e) {
            System.out.println("����̹� �ε� ���� ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
        
        
    }

	public Connection getConn() {
		return conn;
	}
    
}
