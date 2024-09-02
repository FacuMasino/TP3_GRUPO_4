package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class PrincipalAlternativo 
{
	public static void main(String[] args) 
	{
		Archivo archivo = new Archivo("Personas.txt");

		if(archivo.existe("Personas.txt"))
		{
			//archivo.leerLineas();
		}
		else
		{
			archivo.crearArchivo("Personas.txt");
			System.out.println("Archivo creado");
		}
		
		ArrayList<String> datos = new ArrayList<String>();
		datos = archivo.getLineas();
		
		TreeSet<Persona> personas = new TreeSet<Persona>();
		
		String[] aux = new String[3];	//Aca guardo Apellido,Nombre y Dni
		
		for(String d : datos)
		{
			if(d != null && !d.equals(""))
			{
				aux=d.split("-");
				try
				{
					if(DNI.verificarDniInvalido(aux[2]))
					{
						personas.add(new Persona(aux[0],aux[1],aux[2]));
					}
				}
				catch(IOException e)
				{
					e.getMessage();
					e.printStackTrace();
				}
			}
		}
		//MOSTRAMOS DATOS
		for(Persona p : personas)
		{
			System.out.println(p.toString());
		}
	}
		
}


