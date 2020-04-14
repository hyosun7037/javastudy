package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer_clone {

	ServerSocket serverSocket;
	Socket socket;
	BufferedReader br;
	
	public MySocketServer_clone() throws Exception {
		serverSocket = new ServerSocket(14000);
		socket = serverSocket.accept();
		
		System.out.println("��û�� ����");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = "";
		
		while((msg = br.readLine()) != null) {
			System.out.println("���� :" + msg);
		}
		
		br.close();
		socket.close();
		serverSocket.close();
		
	}
	
	public static void main(String[] args) {
		try {
			new MySocketServer_clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
