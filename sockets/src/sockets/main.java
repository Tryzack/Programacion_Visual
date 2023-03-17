package sockets;

import sockets.Hilo;

public class main {
	
    public static void main (String[] args)
    {
          Servidor hi1 = new Servidor();
          Servidor hi2 = new Servidor ();
          Servidor hi3 = new Servidor ();
          
          hi1.start();
          
    }

}
