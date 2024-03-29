package sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String username;
	
	public Cliente(Socket socket, String username) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.username = username;
		} catch (IOException e) {
			cerrartodo(socket, bufferedReader, bufferedWriter);
		}
	}
	
	public void mensaje() {
		try {
			bufferedWriter.write(username);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			Scanner scanner = new Scanner(System.in);
			while(socket.isConnected()) {
				String mensaje = scanner.nextLine();
				bufferedWriter.write(username + ": "+ mensaje);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} catch(IOException e) {
			cerrartodo(socket, bufferedReader, bufferedWriter);
		}
	}
	
	public void listener() {
		new Thread(new Runnable() {
			
			public void run() {
				String mensajedelGrupo;
				
				while(socket.isConnected()) {
					try {
						mensajedelGrupo = bufferedReader.readLine();
						System.out.println(mensajedelGrupo);
					} catch (IOException e) {
						cerrartodo(socket, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}
	
	public void cerrartodo(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		try {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(bufferedWriter != null) {
				bufferedWriter.close();
			}
			if(socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce tu usuario para acceder al chat grupal");
		String username = scanner.nextLine();
		Socket socket = new Socket("localhost", 7531);
		Cliente cliente = new Cliente(socket, username);
		System.out.println("Bienvenido al chat grupal, envia tu primer mensaje: ");
		cliente.listener();
		cliente.mensaje();
	}
}
