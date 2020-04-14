package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {

	// ���ξ������� ���� : �����带 ���� Ŭ������ ��°�� ��Ƽ� �׾��� ������ ���۸� �����ϴ� �� ����

	Vector<NewSocketThread> vt; // Vector = ArrayList�� ���� ��
	ServerSocket serverSocket;

	public MySocketServer() throws Exception {
		vt = new Vector<>(); // �� �÷��� ����
		serverSocket = new ServerSocket(3000); // ���������� �ö󰬱� ������, serverSocket new�� ����

		while (true) {
			Socket socket = serverSocket.accept();
			// accept()���� �� ���� socket�� ���� �ֱٿ� ����� socket�� ����Ŵ,
			// socket ������ ���� �����ؾ��� --> ������ �÷��� ������Ű��
			System.out.println("��û�� ����");
			NewSocketThread nt = new NewSocketThread(socket); // �����尡 ������������� ��� �ѱ�
			Thread newWorker = new Thread(nt); // Ÿ�� �ֱ�
			newWorker.start();
			vt.add(nt); // ������ ��� �ִ� nt�� ������ ��� ���� ������ �� �� ����
		}
	}

	// ���ξ����� : ������ --> �����ϸ� ���� ����� ���ο� �����忡�� ������ �ѱ� --> �ٽ� ���ƿͼ� ������
	// ���ο� ������ : BufferedWriter�� BufferedReader ����(����� ����),
	// �������κ��� �޼����� ������ �������� ������ ��������

	// ���ο� �����忡�� ���۸� ������ �� �ְ� socket�� ����
	
	class NewSocketThread implements Runnable {

		Socket socket;
		BufferedReader br;
		BufferedWriter bw; // �������� ���� ����

		public NewSocketThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // �ޱ�
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // ����

				String msg = "";
				while ((msg = br.readLine()) != null) {
					System.out.println("Ŭ���̾�Ʈ : " + msg);
					for (NewSocketThread newSocketThread : vt) {
						if (newSocketThread != this) { //this�� �ڱ� �ڽ��� ��ü
							newSocketThread.bw.write(msg + "\n"); // readLine�� �� �о����� \n�� ������
							newSocketThread.bw.flush(); // �����Ͱ� �� ������ �Ѱ��ַ��� flush()
						}

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			new MySocketServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
