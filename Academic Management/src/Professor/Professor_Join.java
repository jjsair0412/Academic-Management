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
		
	    // professor_join Table ���� id���� �̾ƿ��� getProfessorId()
	    @Override
		public ArrayList<String> getProfessorId() {
			// id���� ���ؼ� ���� id�� �Ѱ����� �������
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
	            System.out.println("select �޼��� ���ܹ߻�");
	        }    finally {
	            try {
	                if(pstmt!=null && !pstmt.isClosed()) {
	                    pstmt.close();
	                }
	            } catch (Exception e2) {}
	        }
			return ProId;
			
		}
		// professor_join Table pw���� �̾ƿ��� getProfessorPw() 
	    @Override
	    public ArrayList<Integer> getProfessorPw() {
			// id���� ���ؼ� ���� id�� �Ѱ����� �������
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
	            System.out.println("select �޼��� ���ܹ߻�");
	        }    finally {
	            try {
	                if(pstmt!=null && !pstmt.isClosed()) {
	                    pstmt.close();
	                }
	            } catch (Exception e2) {}
	        }
			return ProPw;
		}
		
	
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
            	alarm = new Alarm("ȸ������ �Ϸ�");
            }
        } catch (Exception e) {
        	alarm = new Alarm("�̹� �����ϴ� ID�Դϴ�. �ٽ� �ۼ����ּ���");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {}
        }
        
		
	}

}
