package ejercicio1;

public class Persona implements Comparable<Persona>
{
	private String apellido;
	private String nombre;
	private String dni;
	
	public Persona()
	{
		
	}

	public Persona(String apellido, String nombre, String dni)
	{
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getApellido()
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

	@Override
	public String toString()
	{
		return "Apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{			
			return true;
		}

		if (obj == null)
		{
			return false;
		}

		if (getClass() != obj.getClass())
		{			
			return false;
		}

		Persona other = (Persona) obj;
		
		if (apellido == null)
		{
			if (other.apellido != null)
			{				
				return false;
			}
		}
		else if (!apellido.equals(other.apellido))
		{			
			return false;
		}

		if (dni == null)
		{
			if (other.dni != null)
			{				
				return false;
			}
		}
		else if (!dni.equals(other.dni))
		{			
			return false;
		}

		if (nombre == null)
		{
			if (other.nombre != null)
			{				
				return false;
			}
		}
		else if (!nombre.equals(other.nombre))
		{			
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Persona per)
	{
		if(per.getApellido().compareTo(this.apellido) == 0)
		{
			return 0;
		}
		
		if(per.getApellido().compareTo(this.apellido) < 0)
		{
			return -1;
		}
		
		return 1;
	}
}
