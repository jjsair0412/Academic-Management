package Service.DB.CRUD;

import java.util.ArrayList;

public interface Professor_join_CRUD {
	// ���� ȸ������
	public void Create(String id, String name, int age, String sex, String major, int proPw);
	public ArrayList<String> getProfessorId();
	public ArrayList<Integer> getProfessorPw();
}
