package ejercicio1;

public class DNI {

	public DNI() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean esNumero(char c) {
		// Según la tabla de códigos ASCII los números 0-9 están entre
		// los códigos de caracter 48 y 57. Ver https://www.ascii-code.com/
		if((int)c >= 48 && (int)c <= 57) {
			return true;
		}
		return false;
	}
	
	public static boolean verificarDniInvalido(String nroDNI) throws DniInvalidoException {
		// Recorrer cada caracter de la cadena nroDNI y verificar si es número
		// utilizando la funcion esNumero()
		return true;
	}
}
