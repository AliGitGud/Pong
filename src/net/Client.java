package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import package1.Control;

public class Client extends Thread {

	private Socket connection;
	private PrintWriter out;
	private Control control;

	public Client(Control control, String ipAddress) throws IOException {
		this.control = control;
		try {
			this.connection = new Socket(ipAddress, 8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.out = new PrintWriter(this.connection.getOutputStream());
		this.start();
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
						this.control.setMoveUpGegner(true);
					} else if (line.equalsIgnoreCase(TcpCommands.UP_ENDED)) {
						this.control.setMoveUpGegner(false);
					} else if (line.equalsIgnoreCase(TcpCommands.DOWN_STARTED)) {
						this.control.setMoveDownGegner(true);
					} else if (line.equalsIgnoreCase(TcpCommands.DOWN_ENDED)) {
						this.control.setMoveDownGegner(false);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void send(String text) {
		this.out.println(text);
		this.out.flush();
	}

}
