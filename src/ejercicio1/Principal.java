package ejercicio1;

import java.io.IOException;

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
		
		Persona carlitos = new Persona("Carlos", "Berlinguieri", "1234prueba");
		System.out.println(carlitos.toString());
		
		try
		{
			if (DNI.verificarDniInvalido(carlitos.getDni()))
			{
				System.out.println("Valido.");
			}
			else
			{
				System.out.println("NO valido.");
			}
		}
		catch (IOException e)
		{
			e.getMessage();
			e.printStackTrace();
		}
	}
}