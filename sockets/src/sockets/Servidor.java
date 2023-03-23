package sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Servidor	{
	private ServerSocket srv;
	
	public Servidor(ServerSocket serverSocket) {
		this.srv = serverSocket;
		
	}
	
	public void startServer() {
		try {
			while(!srv.isClosed()) {
				Socket socket = srv.accept();
				System.out.println("Un nuevo cliente se ha conectado!");
				ClientHandler clientHandler = new ClientHandler(socket);
				
				Thread thread = new Thread(clientHandler);
				thread.start();
			}
		} catch (IOException e) {
			
		}
	}
	
	public void closeServerSocket() {
		try {
			if(srv != null) {
				srv.close();
			}
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(7531);
		Servidor servidor = new Servidor(serverSocket);
		servidor.startServer();
	}
}