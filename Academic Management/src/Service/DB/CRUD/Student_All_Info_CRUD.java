package Service.DB.CRUD;

public interface Student_All_Info_CRUD {
	// 시스템의 기능
	// id : id number : 학번, name : 이름, age : 나이, sex : 성별, major : 전공, point : 학점
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point);
	// 행 삭제
	public void	infoDelect(String id);
	// 모든 학생의 정보 가지고옴
	public void infoRead();
	// 학생정보 수정가능
	public void infoUpdate(String whereChange, String changeValue, String id);
	// 한명의 학생정보 가지고옴
	public void selectRead(String id);
}
