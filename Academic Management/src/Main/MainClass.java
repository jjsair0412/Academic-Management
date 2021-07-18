package Main;

import GUI.MyFrame;
import ServiceDBConnection.DB_ConnectionClass;

public class MainClass {
	public static void main(String[] args) {
		DB_ConnectionClass db_Connection = new DB_ConnectionClass();
		MyFrame myFrame = new MyFrame();
		
	}
}
