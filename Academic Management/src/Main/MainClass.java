package Main;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GUI.Loading;
import GUI.MyFrame;
import ServiceDBConnection.DB_ConnectionClass;

public class MainClass {
	public static void main(String[] args) {
		DB_ConnectionClass db_Connection = new DB_ConnectionClass();
		MyFrame myFrame = new MyFrame();
		
	}
}
