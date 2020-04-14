package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {

	Socket socket;
	BufferedWriter bw; //전역으로 올리기
	BufferedReader br; //전역으로 올리기
	
	public MySocketClient() throws Exception {
		socket = new Socket("192.168.0.31", 15000); 
		//서버소켓의 accept()함수 호출, stream에 연결되었다는 의미
		//쓸거면 BufferedWriter 대신 PrintWriter
//		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
//		pw.write("안녕"); //한번만 쓸거면 바로 결과값 넣기
		
//		pw.close();
		
		bw = new BufferedWriter
				(new OutputStreamWriter(socket.getOutputStream()));
		
		br = new BufferedReader
				(new InputStreamReader(System.in));
		
		String msg = "";
		while((msg = br.readLine()) != null) {
			bw.write(msg + "\n"); //키보드로부터 입력받은 값
			bw.flush();
		}
		bw.close();
		br.close();
		socket.close();
	}

	public static void main(String[] args) {
		try {
			new MySocketClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
