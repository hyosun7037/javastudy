package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient_clone {

	Socket socket;
	BufferedWriter bw;
	BufferedReader br;
	
	
	public MySocketClient_clone() throws Exception {
		socket = new Socket("localhost",14000);
		
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = "";
		while((msg = br.readLine())!=null) {
			bw.write(msg + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
		socket.close();
		
	}
	public static void main(String[] args) {
		try {
			new MySocketClient_clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
