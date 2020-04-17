package chatV4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class SocketServer {

	ServerSocket serverSocket;
	Vector<SocketThread> vc;

	public SocketServer() {

		try {

			serverSocket = new ServerSocket(20000);
			vc = new Vector<>();

			while (true) {
				System.out.println("요청대기");
				Socket socket = serverSocket.accept();
				System.out.println("요청받음");
				SocketThread st = new SocketThread(socket);
				st.start();
				vc.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 소켓정보 + 타켓(run) + 식별자(id)
	class SocketThread extends Thread {

		Socket socket;
		String id;
		BufferedReader reader;
		PrintWriter writer;

		public SocketThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);

				writer.println("please Sign in");
				id = reader.readLine();
				System.out.println("요거실행됨");
				System.out.println(id);
				String line = null;
				while ((line = reader.readLine()) != null) {
					router(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void router(String line) {
			String[] guban = line.split(":");
			String protocol = guban[0];
			if (protocol.equals(ChatProtocol.All)) {
				String msg = guban[1];
				allChat(msg);
			} else if (protocol.equals(ChatProtocol.MSG)) {
				String otherId = guban[1];
				String msg = guban[2];
				privateChat(otherId, msg);
			}
		}

		public void allChat(String msg) {
			System.out.println(id + " : " + msg + " ip : " + socket.getInetAddress());
			for (SocketThread socketThread : vc) {
				socketThread.writer.println(id + " : " + msg);
			}
		}

		private void privateChat(String otherId, String msg) {
			System.out.println(id + " : " + msg + " ip : " + socket.getInetAddress());
			for (SocketThread socketThread : vc) {
				if (socketThread.id.equals(otherId)) {
					socketThread.writer.println(id + " : " + msg);
				} else {
					writer.println("아이디를 찾을 수 없습니다.");
				}
			}

		}

	}

	public static void main(String[] args) {
		new SocketServer();
	}

}
