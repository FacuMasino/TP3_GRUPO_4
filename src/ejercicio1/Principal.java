package ejercicio1;

public class Principal
{
	public static void main(String[] args)
	{	
		ManagerPersonas mgrPersonas = new ManagerPersonas();
		System.out.println("********OBTENIENDO LISTADO DE PERSONAS********\n");
		mgrPersonas.mostrarPersonas();
		System.out.println("********GUARDANDO INFO EN ARCHIVO NUEVO********\n");
		
		if (mgrPersonas.guardarResultado())
		{
			System.out.println("-----RESULTADO:Listado guardado correctamente en archivo-----");
		}
		else 
		{
			System.out.println("-----RESULTADO: Error al generar archivo nuevo-----");
		}
	}
	
	
}