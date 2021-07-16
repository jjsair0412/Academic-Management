package SocketConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private OutputStream outputStream = null;
	private DataOutputStream dataOutputStream = null;
	
	private InputStream inputStream = null;
	private DataInputStream dataInputStream = null;
	
	private ServerSocket serverSocket = null;
	// ServerSocket 레퍼런스 생성
	private Socket socket = null;
	// Socket 레퍼런스 생성
	
	public Server() {

		try {
			// 네트워크 관련 작업은, 예외처리가 필수이다.
			
			// ServerSoket의 레퍼런스를 생성할때, 매게변수로 포트번호를 입력해준다.
			
			// localhost의 포트번호 9000번에게 응답을 요청한다.
			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트를 맞을 준비가 되었습니다!");
		
			// 클라이언트가 요청하면, serverSoket의 accept()가 실행되고, accept() 메서드는 soket을 반환한다.
			// 요청을 accept가 받아서 socket에 넣는다.
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결완료!!");
			
			// 소켓으로부터 inputStream 객체를 꺼내온다.
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			while(true) {
				String clientMassge = dataInputStream.readUTF();
				System.out.println("클라이언트가 보낸 메세지 : "+ clientMassge);
				
				dataOutputStream.writeUTF("데이터 전송 완료");
				dataOutputStream.flush();
				
				if(clientMassge.equals("stop")) {
					break;
				}
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket !=null) {
					socket.close();
				}
				if(serverSocket != null) {
					serverSocket.close();
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
		
	}
}
