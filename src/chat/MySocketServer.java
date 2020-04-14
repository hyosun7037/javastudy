package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {

	// 메인쓰레드의 역할 : 쓰레드를 만들어서 클래스를 통째로 담아서 그안의 소켓의 버퍼를 연결하는 게 편함

	Vector<NewSocketThread> vt; // Vector = ArrayList와 같은 것
	ServerSocket serverSocket;

	public MySocketServer() throws Exception {
		vt = new Vector<>(); // 빈 컬렉션 생성
		serverSocket = new ServerSocket(3000); // 전역변수로 올라갔기 때문에, serverSocket new로 선언

		while (true) {
			Socket socket = serverSocket.accept();
			// accept()받을 때 마다 socket은 가장 최근에 연결된 socket만 가리킴,
			// socket 변수를 따로 보관해야함 --> 보관할 컬렉션 생성시키기
			System.out.println("요청이 들어옴");
			NewSocketThread nt = new NewSocketThread(socket); // 스레드가 만들어질때마다 계속 넘김
			Thread newWorker = new Thread(nt); // 타켓 넣기
			newWorker.start();
			vt.add(nt); // 소켓을 들고 있는 nt를 담으면 모든 소켓 정보를 알 수 있음
		}
	}

	// 메인쓰레드 : 연결대기 --> 연결하면 소켓 만들고 새로운 스레드에서 소켓을 넘김 --> 다시 돌아와서 연결대기
	// 새로운 쓰레드 : BufferedWriter와 BufferedReader 연결(통신을 위해),
	// 상대방으로부터 메세지를 받으면 누구한테 보낼지 결정해줌

	// 새로운 쓰레드에서 버퍼를 연결할 수 있게 socket을 전달
	
	class NewSocketThread implements Runnable {

		Socket socket;
		BufferedReader br;
		BufferedWriter bw; // 전역으로 변수 빼줌

		public NewSocketThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 받기
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 쓰기

				String msg = "";
				while ((msg = br.readLine()) != null) {
					System.out.println("클라이언트 : " + msg);
					for (NewSocketThread newSocketThread : vt) {
						if (newSocketThread != this) { //this는 자기 자신의 객체
							newSocketThread.bw.write(msg + "\n"); // readLine이 안 읽어져서 \n을 적어줌
							newSocketThread.bw.flush(); // 데이터가 꽉 안차도 넘겨주려고 flush()
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
