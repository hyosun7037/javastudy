package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient {

	Socket socket; //전역변수
	// Vector가 소켓 정보 다 들고 있음
	// 메인 -- 1.키보드 입력대기
	// 새로운 쓰레드 -- 1. 계속 read해서 입력받은 데이터를 화면에 출력하도록 함

	public MySocketClient() throws Exception {
		socket = new Socket("192.168.0.17", 3000); //새로운 소켓
		
		ReadThread rt = new ReadThread();
		Thread newWorker = new Thread(rt);
		newWorker.start();
		
		//new Thread(new ReadThread()).start(); 위의 세줄과 똑같은 말
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
		
		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
				
		
		//메인쓰레드는 여기서 무한 루프
		String outputMsg = "";
		while((outputMsg = keyboardIn.readLine()) != null) {
			bw.write(outputMsg + "\n");
			bw.flush(); // 메인의 역할
		}
	}
	
	//내부 클래스 - BufferedReader 달아서 읽기
	class ReadThread implements Runnable{
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputMsg = "";
				while((inputMsg = br.readLine()) != null) {
					System.out.println("상대방 :" + inputMsg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		
		try {
			new MySocketClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
