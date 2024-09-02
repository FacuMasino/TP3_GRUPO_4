package ejercicio1;


public class Principal
{
	public static void main(String[] args)
	{	
		Archivo archivo = new Archivo("Personas.txt");
			
		if(archivo.existe("Personas.txt"))
		{
			archivo.leerLineas();
		}
		else
		{
			archivo.crearArchivo("Personas.txt");
			System.out.println("Archivo creado");
		}
	}
}