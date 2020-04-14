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
	BufferedWriter bw; //�������� �ø���
	BufferedReader br; //�������� �ø���
	
	public MySocketClient() throws Exception {
		socket = new Socket("192.168.0.31", 15000); 
		//���������� accept()�Լ� ȣ��, stream�� ����Ǿ��ٴ� �ǹ�
		//���Ÿ� BufferedWriter ��� PrintWriter
//		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
//		pw.write("�ȳ�"); //�ѹ��� ���Ÿ� �ٷ� ����� �ֱ�
		
//		pw.close();
		
		bw = new BufferedWriter
				(new OutputStreamWriter(socket.getOutputStream()));
		
		br = new BufferedReader
				(new InputStreamReader(System.in));
		
		String msg = "";
		while((msg = br.readLine()) != null) {
			bw.write(msg + "\n"); //Ű����κ��� �Է¹��� ��
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
