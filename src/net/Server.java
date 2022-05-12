package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import package1.Control;

public class Server {

	private ServerSocket server;
	private ConnectionSocket connection;

	public Server(Control control) {
		try {
			this.server = new ServerSocket(8080);
		} catch (IOException e) {
		}

		new Thread(new Runnable() {
			public void run() {
				Socket socket = null;
				boolean connected = false;
				while (!connected) {
					try {
						socket = server.accept();
					} catch (IOException e) {
						continue;
					}
					connection = new ConnectionSocket(control, socket);
					connection.start();
					connected = true;
				}
			}
		}).start();
	}
}
