package Service.DB.CRUD;

public interface Professor_join_CRUD {
	// ���� ȸ������
	public void Create(String id, String name, int age, String sex, String major, int proPw);
	// ���� �ڱ����� ����
	public void Read();
	// ���� �ڱ����� ����
	public void Update();
	// ���� ȸ�� Ż��
	public void Drop();
}
