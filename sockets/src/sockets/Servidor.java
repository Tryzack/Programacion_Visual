package sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;


public class Servidor extends Thread{
	private ServerSocket srv;
	private final int puerto = 7531;
	private Socket srvListen;
	
	public Servidor() {
		
	}

	public void run() {
		Servidor s = new Servidor();
		s.listener_socket();	
	}
	
	public static void main(String[] args) {
		while(true) {
			Servidor s = new Servidor();
			s.listener_socket();			
		}
	}
	
	public boolean createSocketSrv(int port) {
		try {
			
			srv = new ServerSocket(port);
			return true;
			
		} catch (IOException e) {
			
			return false;
			
		}
	}

	public void listener_socket() {
		createSocketSrv(puerto);
		try {
				System.out.println("esperando solicitud...!");
				srvListen = srv.accept();
				InputStream in = srvListen.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				System.out.println("Mensaje Recibido: "+msg);
				this.sentToCliente("Mensaje recibido ok ... (Srv)");
				srv.close();
				
		}catch (IOException e)
	    {
		      System.out.print("error al escuchar el mensaje del cliente..!");
		    }

	}
	
	public void sentToCliente(String data) {
		try
	    {
	      System.out.println("Enviando Respuesta...");
	      BufferedWriter wr = new BufferedWriter( new 
	      OutputStreamWriter(srvListen.getOutputStream()));
	      wr.write(data);
	      wr.flush();
	      wr.close();
	      srvListen.close();
	    }
	    catch (IOException e)
	    {
	      System.out.println("error al enviar respuesta:"+e.getMessage());
	    }

	}
}
