package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GUI.MyFrame;
import Professor.DB;
import Service.DB_ConnectionClass;

public class MainClass {
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
		DB_ConnectionClass db_Connection = new DB_ConnectionClass();
	}
}
