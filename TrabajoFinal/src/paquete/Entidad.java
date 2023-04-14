package paquete;

public class Entidad {
	
	public Entidad(int id, String nombre, String apellido, int edad) {
		
		this.id = id;
		
		this.nombre = nombre;
		
		this.apellido = apellido;
		
		this.edad = edad;
		
	}
		
	@ColumnAnnotation(Campo="Cedula", LlavePrimaria=true) private int id;
	
	@ColumnAnnotation(Campo="Nombre", LlavePrimaria=false) private String nombre;
	
	@ColumnAnnotation(Campo="Apellido", LlavePrimaria=false) private String apellido;
	
	@ColumnAnnotation(Campo="Edad", LlavePrimaria=false) private int edad;
	
	public String toString() {
		return "Cedula: " + id + "\nNombre: "+ nombre + "\nApellido: " + apellido + "\nEdad: " + edad + "\n";
	}
	
	public void setCedula(int ci) {
		id = ci;
	}
	
	public int getCedula() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
}

