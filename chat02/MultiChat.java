package com.sxt.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Server-----");
		ServerSocket server = new ServerSocket(8888);
		while (true) {
			Socket client = server.accept();
			System.out.println("One client has connected");

			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());

			boolean isRunning = true;
			while (isRunning) {
				String msg = dis.readUTF();
				dos.writeUTF(msg);
				dos.flush();
			}
			dos.close();
			dis.close();
			client.close();
		}

	}
}
