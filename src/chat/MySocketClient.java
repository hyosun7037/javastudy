package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient {

	Socket socket; //��������
	// Vector�� ���� ���� �� ��� ����
	// ���� -- 1.Ű���� �Է´��
	// ���ο� ������ -- 1. ��� read�ؼ� �Է¹��� �����͸� ȭ�鿡 ����ϵ��� ��

	public MySocketClient() throws Exception {
		socket = new Socket("192.168.0.17", 3000); //���ο� ����
		
		ReadThread rt = new ReadThread();
		Thread newWorker = new Thread(rt);
		newWorker.start();
		
		//new Thread(new ReadThread()).start(); ���� ���ٰ� �Ȱ��� ��
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
		
		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
				
		
		//���ξ������ ���⼭ ���� ����
		String outputMsg = "";
		while((outputMsg = keyboardIn.readLine()) != null) {
			bw.write(outputMsg + "\n");
			bw.flush(); // ������ ����
		}
	}
	
	//���� Ŭ���� - BufferedReader �޾Ƽ� �б�
	class ReadThread implements Runnable{
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputMsg = "";
				while((inputMsg = br.readLine()) != null) {
					System.out.println("���� :" + inputMsg);
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
