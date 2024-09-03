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
	private int cantidadDeRegistros;

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
		return archivo.exists();
	}
	
	public boolean existe()
	{
		File archivo = new File(ruta);		
		return archivo.exists();
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
	
	public ArrayList<String> getLineas()
	{
		FileReader fr;
		
		try
		{
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr);
			String linea="";
			ArrayList<String> lineas = new ArrayList<String>();
			
			while(linea != null)
			{
				linea = bfr.readLine();
				if(linea != null && !linea.equals(""))
				{
					lineas.add(linea);					
				}
			}
			
			bfr.close();
			fr.close();
			return lineas;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
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
		
		cantidadDeRegistros = 0;
		
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

	private Persona crearPersonaLinea(String strPersona) {
		String[] arrDatos;
		if(strPersona != null && !strPersona.equals("")) {
			arrDatos = strPersona.split("-");
			if(arrDatos.length == 3) {
				return new Persona(arrDatos[0], arrDatos[1], arrDatos[2]);
			}
		}
		return null;
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
				Persona auxPersona = crearPersonaLinea(linea);
				if(auxPersona != null) gentes.add(auxPersona);
				
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
