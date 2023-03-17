package sockets;



public class Hilo extends Thread{
	
	public void run() {
		try {
			
			Servidor s = new Servidor();
			s.listener_socket();
			
		} catch(Exception e) {
			System.out.println("El hilo fallo o se cayo, error: "+e);
		}
	}
}