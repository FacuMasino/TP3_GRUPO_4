package ejercicio1;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Archivo archivo = new Archivo("Personas.txt");
		
	if(archivo.existe("Personas.txt")) {
		
		archivo.leerLineas();
	} else {
		
		archivo.crearArchivo("Personas.txt");
		System.out.println("Archivo creado");
	}

}
}