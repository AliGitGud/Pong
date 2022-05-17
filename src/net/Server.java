package net;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;

import package1.Control;

public class Server {

	private ServerSocket server;
	private HashMap<Integer, ConnectionSocket> connections;

	public Server(Control control) {
		this.connections = new HashMap<Integer, ConnectionSocket>();
		try {
			this.server = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server running");

		new Thread(new Runnable() {
			public void run() {
				Socket socket = null;
				boolean connected = false;
				int i = 0;
				while (!connected) {
					try {
						socket = server.accept();
					} catch (IOException e) {
						continue;
					}
					if (socket != null) {
						System.out.println("Connection established");
						ConnectionSocket tmp = new ConnectionSocket(control, socket, i);
						connections.put(i, tmp);
						i++;
						tmp.start();
						if (connections.size() >= 2) {
							connected = true;
							control.startGame();
						}
						socket = null;
					}
				}
			}
		}).start();
	}

	public void sendTo(int recipient, String message) {
		this.connections.get(recipient).send(message);
	}

	public String getIp(){
		try {
			return InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
}
