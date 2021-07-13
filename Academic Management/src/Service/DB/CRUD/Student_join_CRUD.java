package Service.DB.CRUD;

import java.util.ArrayList;

public interface Student_join_CRUD {
	// 학생 회원가입
	public void Create(String id, int number, String name, int age, String sex, String major, int StdPw);
	public ArrayList<String> getStudentId();
	public ArrayList<Integer> getStudentPw();

}
