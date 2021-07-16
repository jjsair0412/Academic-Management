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
	// ServerSocket ���۷��� ����
	private Socket socket = null;
	// Socket ���۷��� ����
	
	public Server() {

		try {
			// ��Ʈ��ũ ���� �۾���, ����ó���� �ʼ��̴�.
			
			// ServerSoket�� ���۷����� �����Ҷ�, �ŰԺ����� ��Ʈ��ȣ�� �Է����ش�.
			
			// localhost�� ��Ʈ��ȣ 9000������ ������ ��û�Ѵ�.
			serverSocket = new ServerSocket(9000);
			System.out.println("Ŭ���̾�Ʈ�� ���� �غ� �Ǿ����ϴ�!");
		
			// Ŭ���̾�Ʈ�� ��û�ϸ�, serverSoket�� accept()�� ����ǰ�, accept() �޼���� soket�� ��ȯ�Ѵ�.
			// ��û�� accept�� �޾Ƽ� socket�� �ִ´�.
			socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ ����Ϸ�!!");
			
			// �������κ��� inputStream ��ü�� �����´�.
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			while(true) {
				String clientMassge = dataInputStream.readUTF();
				System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : "+ clientMassge);
				
				dataOutputStream.writeUTF("������ ���� �Ϸ�");
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
