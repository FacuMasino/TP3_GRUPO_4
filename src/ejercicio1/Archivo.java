package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo
{
	private String ruta;
	private static int cantidadDeRegistros;

	public Archivo()
	{
		cantidadDeRegistros = 0;
	}

	public Archivo(String ruta)
	{
		this.ruta = ruta;
		cantidadDeRegistros = 0;
	}

	public boolean existe(String ruta)
	{
		File archivo = new File(ruta);
		
		if (archivo.exists())
		{
			return true;
		}

		return false;
	}
	
	public boolean crearArchivo(String ruta)
	{
		FileWriter escritura;
		
		try
		{
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void escribirLetraPorLetra(String frase)
	{
		try
		{
			FileWriter fw = new FileWriter(ruta, true);
			
			for(int i = 0; i < frase.length(); i++)
			{
				fw.write(frase.charAt(i));
			}
			
			fw.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void escribirLineas(String frase)
	{
		try
		{
			FileWriter fw = new FileWriter(ruta, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write(frase);
			bfw.close();
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void leerLetraPorLetra()
	{
		FileReader entrada;
		
		try
		{
			entrada = new FileReader(ruta);
			int c = entrada.read();
			
			while(c != -1)
			{
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			
			entrada.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void leerLineas()
	{
		FileReader fr;
		
		try
		{
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr);
			String linea = "";
			
			while(linea != null)
			{
				System.out.println(linea);
				linea = bfr.readLine();
			}
			
			bfr.close();
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getRuta()
	{
		return ruta;
	}

	public void setRuta(String ruta)
	{
		this.ruta = ruta;
	}

	public int getCantidadDeRegistros()
	{
		setCantidadDeRegistros();
		return cantidadDeRegistros;
	}

	private void setCantidadDeRegistros()
	{
		FileReader fr;
		
		try
		{
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr);
			String linea = "";
			
			while(linea != null)
			{
				cantidadDeRegistros++;
				linea = bfr.readLine();
			}
			
			bfr.close();
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// Lista todas las personas, sin filtrar repetidos ni invalidos
	public ArrayList<Persona> listarGentes()
	{
		setCantidadDeRegistros();
		ArrayList<Persona> gentes = new ArrayList<Persona>(cantidadDeRegistros);
		
		FileReader fr;
		
		try
		{
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr);
			String linea = "";
			linea = bfr.readLine();
			
			while(linea != null)
			{
				String nombre = "";
				String apellido = "";
				String dinii = "";
				
				nombre = readCSVdata(0, linea);
				apellido = readCSVdata(1, linea);
				dinii = readCSVdata(2, linea);

				Persona persona = new Persona(nombre, apellido, dinii);
				gentes.add(persona);
				
				linea = bfr.readLine();
			}
			
			bfr.close();
			fr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return gentes;
	}
	
	private String readCSVdata(int column, String str)
	{
		ArrayList<String> arr = new ArrayList<String>(3);
		
		arr.add("");
		arr.add("");
		arr.add("");

		int index = 0;
		String aux = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != '-')
			{				
				aux += str.charAt(i);
			}
			else
			{
				arr.set(index, aux);
				index ++;
				aux="";
			}
		}
		
		arr.set(index, aux);
		
		return arr.get(column);
	}
}
