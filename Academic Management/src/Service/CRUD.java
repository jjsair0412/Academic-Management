package Service;

public interface CRUD {
	// 시스템의 기능
	// id : id number : 학번, name : 이름, age : 나이, sex : 성별, major : 전공, point : 학점
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point);
	public void	infoDelect();
	public void infoRead();
	public void infoUpdate();
}
