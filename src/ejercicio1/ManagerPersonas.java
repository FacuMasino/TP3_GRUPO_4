package ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ManagerPersonas {

	Archivo archivo;
	int totalDniInvalidos = 0;
	
	public ManagerPersonas() {
		archivo = new Archivo("Personas.txt"); // Archivo por defecto
	}
	
	public ManagerPersonas(String rutaArchivo) {
		archivo = new Archivo(rutaArchivo);
	}
	
	public TreeSet<Persona> getListaPersonas() {
		if(!archivo.existe()) {
			return null;
		}
		
		ArrayList<Persona> personasArchivo = new ArrayList<Persona>(archivo.getCantidadDeRegistros());
		TreeSet<Persona> listaFiltrada = new TreeSet<Persona>();
		
		personasArchivo = archivo.listarGentes();
		
		for(Persona p: personasArchivo) {
			try {				
				if(DNI.verificarDniInvalido(p.getDni())) {
					listaFiltrada.add(p);
				}
			} catch (IOException e) {
				totalDniInvalidos++;
				e.printStackTrace();
			}
		}
		
		return listaFiltrada;
	}
	
	public void mostrarPersonas() {
		TreeSet<Persona> personas = new TreeSet<Persona>();
		personas = getListaPersonas();
		
		if(personas == null) {
			System.out.println("No hay registros, verifique que el archivo exista.");
			return;
		}
		
		for(Persona p: personas) {
			System.out.println(p.toString());
		}
		
		int totalRegistros = archivo.getCantidadDeRegistros();
		int duplicados = (totalRegistros - totalDniInvalidos) - personas.size();
		System.out.println("\nTotal Registros: " + totalRegistros);
		System.out.println("Total DNI Inválidos: " + totalDniInvalidos);
		System.out.println("Total Duplicados: " + duplicados);
		System.out.println("Total Personas: " + personas.size());
	}
	
	public boolean exportarLista(String rutaArchivo) {
		return false;
	}

}
