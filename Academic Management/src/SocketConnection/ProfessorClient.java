package SocketConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ProfessorClient {
	private String messageStu = null; 
	
	public String ProfessorMessageToStu(String message) {
		
		Socket socket = null;
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		try {
			socket = new Socket("localhost",9000);
			System.out.println("서버 연결 완료");
			System.out.println("Socket : "+ socket);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			
			while(true) {
				// 학생이 보낸 메세지를 읽어온다.
				messageStu = dataInputStream.readUTF();
				System.out.println("학생이 보낸 메세지 : "+messageStu);
				this.messageStu = messageStu;
				
				
				// 서버쪽으로 입력한 데이터를 보낸다.
				dataOutputStream.writeUTF(message);
				dataOutputStream.flush();
				
				if(message.equals("stop")) {
					break;
				}
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(dataOutputStream != null) {
					dataOutputStream.close();
				}
				if(inputStream != null) {
					inputStream.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return messageStu;
	}
}
