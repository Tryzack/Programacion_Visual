package conectaBD;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class Conecta_Pruebas {
	
	public static Connection conectarse() {
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productos", "postgres", "joseandres10");
			
			return miConexion;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: \n"+e.toString());
			return null;
		}
	}
}
