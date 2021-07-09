package Service;

public interface CRUD {
	// �ý����� ���
	// id : id number : �й�, name : �̸�, age : ����, sex : ����, major : ����, point : ����
	public void infoCreate(String id, int number, String name, int age, String sex, String major, int point);
	// �� ����
	public void	infoDelect(String id);
	// ��� �л��� ���� �������
	public void infoRead();
	// �л����� ��������
	public void infoUpdate(String whereChange, String changeValue, String id);
	// �Ѹ��� �л����� �������
	public void selectRead(String id);
}
