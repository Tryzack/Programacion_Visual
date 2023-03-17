package sockets;

import java.net.Socket;
import java.io.IOException;
import java.io.*;

public class Cliente {
	private String msg;
	private Socket cliente;
	private static InputStreamReader streamIn =  new InputStreamReader(System.in);
	private static BufferedReader in =  new BufferedReader(streamIn, 1);
	
	public Cliente()
	{
		msg="";
	}
	
	public static void main(String[] args)
	{
		try{
			Cliente c = new Cliente();
			System.out.print("Introduzca Mensaje:");
			c.msg = c.readKey();
			c.createSocketClient("localHost", 7531);
			c.socketSend(c.msg);
			Thread.sleep(1000);
			System.out.print(c.getServerMsj());
			c.cliente.close();
			
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
	public String readKey() {
		String line = null;
		try{
			line = in.readLine();
		}	catch (IOException e) {
			System.out.println("Error in SimpleIO.readLine: " +  e.getMessage());
			System.exit(-1);
		}
		return line;
	}

	//Se crea una instancia del socket client
	public boolean createSocketClient(String host, int port)
	{
		try{
			cliente = new Socket(host, port);
			return true;
		}
		catch (IOException e){
			return false;
		}
	}
	
	public String getServerMsj()
	{
		try	{
			BufferedReader rd = new 
			BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String contenido="**************************************\n";
			while (rd.ready()) {
				contenido+= rd.readLine()+"\n";
			}
			rd.close();
			contenido+="**************************************\n";
			return contenido;
		}
		catch (IOException e){
			return "error en proceso de obtención de mensaje desde el servidor";
		}
	}

	public boolean socketSend(String data)
	{
		try{
			PrintStream ps = new PrintStream(cliente.getOutputStream());
			ps.println(data);
			ps.flush();
			return true;
		}
		catch(IOException e){
			return false;
		}
	}

}
