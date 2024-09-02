package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;

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
		
		System.out.println("Cantidad de registros: " + archivo.getCantidadDeRegistros());

		ArrayList<Persona> gentes = new ArrayList<Persona>(archivo.getCantidadDeRegistros());
		gentes = archivo.listarGentes();
		
		System.out.println("Registro 8:");
		System.out.println(gentes.get(7).toString()); // invalido
		
		System.out.println("Registro 2:");
		System.out.println(gentes.get(1).toString()); // repedito
		
		System.out.println("Registro 4:");
		System.out.println(gentes.get(3).toString()); // retepido

		System.out.println("Carlitos:");
		Persona carlitos = new Persona("Carlos", "Berlinguieri", "1234prueba");
		System.out.println(carlitos.toString() + "\n");
		
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