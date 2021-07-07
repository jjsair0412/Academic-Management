package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_ConnectionClass {
	private Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "pw12";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    // 사용할 DBMS이름,호스트 IP주소:포트번호/database 이름 순서로 작성한다
    
    public DB_ConnectionClass() {
        try {
            System.out.println("데이터베이스 연결중..");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
        
        
    }

	public Connection getConn() {
		return conn;
	}
    
}
