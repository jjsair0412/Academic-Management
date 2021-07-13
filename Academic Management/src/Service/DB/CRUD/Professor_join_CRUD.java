package Service.DB.CRUD;

import java.util.ArrayList;

public interface Professor_join_CRUD {
	// 교수 회원가입
	public void Create(String id, String name, int age, String sex, String major, int proPw);
	public ArrayList<String> getProfessorId();
	public ArrayList<Integer> getProfessorPw();
}
