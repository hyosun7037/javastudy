package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient_clone {

	Socket socket;

	public MySocketClient_clone() throws Exception {
		socket = new Socket("localhost", 3000);

		ReadThread rt = new ReadThread();
		Thread newWorker = new Thread(rt);
		newWorker.start();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));

		String outputMsg = "";
		while ((outputMsg = keyboardIn.readLine()) != null) {
			bw.write(outputMsg + "\n");
			bw.flush();
		}
	}

	class ReadThread implements Runnable {
		@Override
		public void run() {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputMsg = "";
				while ((inputMsg = br.readLine()) != null) {
					System.out.println("»ó´ë¹æ : " + inputMsg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	public static void main(String[] args) {
		try {
			new MySocketClient_clone();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
