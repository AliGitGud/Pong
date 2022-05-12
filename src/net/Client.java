package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.SocketException;

import package1.Control;

public class Client extends Thread {

	private Socket connection;
	private PrintWriter out;
	private Control control;

	public Client(Control control, Inet4Address ipAddress) throws IOException {
		this.control = control;
		try {
			this.connection = new Socket(ipAddress, 8080);
		} catch (Exception e) {
		}
		this.out = new PrintWriter(this.connection.getOutputStream());
	}

	@Override
	public void run() {
		BufferedReader in;

		try {
			in = new BufferedReader(new InputStreamReader(this.connection.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			// Cancel execution
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
					// TODO: Add commands
				}
			} catch (SocketException e) {
				// TODO: Handle Disconnect
			} catch (IOException e) {
				// TODO: Handle IOException
			}
		}
	}

}
