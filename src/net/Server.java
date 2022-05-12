package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import package1.Control;

public class Server {

	private ServerSocket server;
	private ArrayList<ConnectionSocket> connections;

	public Server(Control control) {
		this.connections = new ArrayList<ConnectionSocket>();
		try {
			this.server = new ServerSocket(8080);
		} catch (IOException e) {
		}

		System.out.println("Server running.");

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
					System.out.println("Connection established");
					ConnectionSocket tmp = new ConnectionSocket(control, socket);
					connections.add(tmp);
					tmp.start();
					if (connections.size() >= 2) {
						connected = true;
					}
				}
			}
		}).start();
	}
}
