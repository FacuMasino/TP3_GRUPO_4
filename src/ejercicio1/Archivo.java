package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

	private String ruta;

	public Archivo() {

	}

	public Archivo(String ruta) {
		this.ruta = ruta;
	}

	public boolean existe(String ruta) {

		File archivo = new File(ruta);
		if (archivo.exists()) {
			return true;
		}

		return false;
	}
	
	public boolean crearArchivo(String ruta) {
		
		FileWriter escritura;
		
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			
			return true;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void escribirLetraPorLetra(String frase) {
		
		try {
			FileWriter fw = new FileWriter(ruta, true);
			
			for(int i = 0; i < frase.length(); i++) {
				
				fw.write(frase.charAt(i));
			}
			
			fw.close();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void escribirLineas(String frase) {
		
		try {
			FileWriter fw = new FileWriter(ruta, true);
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write(frase);
			bfw.close();
			fw.close();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void leerLetraPorLetra() {
		
		FileReader entrada;
		
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read();
			while(c != -1) {
				
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			
			entrada.close();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void leerLineas() {
		
		FileReader fr;
		
		try {
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader(fr);
			String linea = "";
			
			while(linea != null) {
				
				System.out.println(linea);
				linea = bfr.readLine();
			}
			
			bfr.close();
			fr.close();
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
