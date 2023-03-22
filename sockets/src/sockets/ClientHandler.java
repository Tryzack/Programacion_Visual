package sockets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
	
	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();	
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String clientUser;

	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.clientUser = bufferedReader.readLine();
			clientHandlers.add(this);
			mensaje("SERVIDOR: "+clientUser+" ha entrado al chat");
		} catch (IOException e) {
			cerrartodo(socket, bufferedReader, bufferedWriter);
		}
	}
	
	@Override
	public void run() {
		String mensajedelCliente;
		
		while(socket.isConnected()) {
			try {
				mensajedelCliente = bufferedReader.readLine();
				mensaje(mensajedelCliente);
				}catch (IOException e) {
					cerrartodo(socket, bufferedReader, bufferedWriter);
					break;
				}
		}
	}
	
	public void mensaje(String mensajeAEnviar) {
		for(ClientHandler clientHandler : clientHandlers) {
			try {
				if(!clientHandler.clientUser.equals(clientUser)) {
					clientHandler.bufferedWriter.write(mensajeAEnviar);
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
				}
			}catch (IOException e) {
				cerrartodo(socket, bufferedReader, bufferedWriter);
			}
		}
	}
	
	public void quitarCliente() {
		clientHandlers.remove(this);
		mensaje("SERVIDOR: "+ clientUser + " ha salido del chat");
	}
	
	public void cerrartodo(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		quitarCliente();
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
}
