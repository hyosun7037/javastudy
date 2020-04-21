package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket; // 소켓 생성
	Socket socket;
	BufferedReader br; // 전역으로 빼줌

	public MySocketServer() throws Exception {

		serverSocket = new ServerSocket(15000); // 서버 소켓 생성
		socket = serverSocket.accept(); // 요청대기

		System.out.println("요청이 들어옴");

		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = "";

		while ((msg = br.readLine()) != null) {
			System.out.println("상대방 :" + msg);
		}

		br.close();
		socket.close();
		serverSocket.close();

	}

	public static void main(String[] args) {
		try {
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
