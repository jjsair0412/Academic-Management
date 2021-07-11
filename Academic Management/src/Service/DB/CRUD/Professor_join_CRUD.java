package Service.DB.CRUD;

public interface Professor_join_CRUD {
	// 교수 회원가입
	public void Create(String id, String name, int age, String sex, String major, int proPw);
	// 교수 자기정보 열람
	public void Read();
	// 교수 자기정보 수정
	public void Update();
	// 교수 회원 탈퇴
	public void Drop();
}
