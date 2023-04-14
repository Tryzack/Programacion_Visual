package paquete;

import java.lang.reflect.*;
import java.util.*;

public class Main {

	static Map<Integer, Entidad> persona = new HashMap<Integer, Entidad>();
	
	public static void main(String[] args) {
			
			persona.put(1, new Entidad(8504466, "Jose", "Chacon", 19));

			mostrarDatos();
		
		try {
			
			Field[] fields = Entidad.class.getDeclaredFields();	
			
			for (var field : fields) {
				
				ColumnAnnotation anotacion = field.getAnnotation(ColumnAnnotation.class);
				System.out.println("Campo = "+anotacion.Campo() + "\nPK = "+anotacion.LlavePrimaria() + "\nValor = "+field.getName()+"\n");
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarDatos() {
		
		for (var itr : persona.entrySet()) {
			System.out.println(itr.getKey()+" "+itr.getValue());
			
		}
		
	}
	
}
