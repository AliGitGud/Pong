package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import package1.Control;

public class ConnectionSocket extends Thread {

	private Socket connection;
	private PrintWriter out;
	private Control control;
	private int uid;
	private int enemy;

	public ConnectionSocket(Control control, Socket connection, int uid) {
		this.control = control;
		this.connection = connection;
		this.uid = uid;
		if (this.uid == 1) {
			this.enemy = 0;
		} else {
			this.enemy = 1;
		}
		try {
			this.out = new PrintWriter(this.connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		BufferedReader in;

		try {
			in = new BufferedReader(new InputStreamReader(this.connection.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		while (!Thread.currentThread().isInterrupted()) {
			String line;
			try {
				if (in.ready()) {
					line = in.readLine();
					if (line == null || line.isBlank() || line.isEmpty()) {
						// Don't process emtpy lines
						continue;
					}

					if (line.equalsIgnoreCase(TcpCommands.UP_STARTED)) {
						this.control.getServer().sendTo(enemy, TcpCommands.UP_STARTED);
					} else if (line.equalsIgnoreCase(TcpCommands.UP_ENDED)) {
						this.control.getServer().sendTo(enemy, TcpCommands.UP_ENDED);
					} else if (line.equalsIgnoreCase(TcpCommands.DOWN_STARTED)) {
						this.control.getServer().sendTo(enemy, TcpCommands.DOWN_STARTED);
					} else if (line.equalsIgnoreCase(TcpCommands.DOWN_ENDED)) {
						this.control.getServer().sendTo(enemy, TcpCommands.DOWN_ENDED);
					}
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void send(String message) {
		this.out.println(message);
		this.out.flush();
	}
}
