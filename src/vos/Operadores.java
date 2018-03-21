package vos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;


public class Operadores
{	
	private final static int CAPACIDAD=100;
	private static int ESTUDIANTE=1;
	private static int EGRESADO=2;
	private static int PROFESOR=3;
	private static int EMPLEADO=4;
	private static int PADRE_DE_ESTUDIANTE=5;
	private static int PROFESOR_INVITADO=6;
	//Atributos 
	@JsonProperty(value="Nombre")
	protected String Nombre;
	@JsonProperty(value="Tipo")
	protected int Tipo;
	@JsonProperty(value="MinDeTiempo")
	protected double MinDeTiempo;
	@JsonProperty(value="Capacidad")
	protected double Capacidad;
	@JsonProperty(value="id")
	protected  Long id;
	
	
	//Asociaciones
	@JsonProperty(value="Propuestas")
	protected List<Propuesta> Propuestas;



    //Constructor
	public Operadores(@JsonProperty(value="Nombre")String nombre,@JsonProperty(value="Tipo") int  tipo,@JsonProperty(value="MinDeTiempo") double minTiempo,@JsonProperty(value="Capacidad")double capacidad,@JsonProperty(value="id") Long id)
	{
		this.Nombre=nombre;
		this.Tipo=tipo;
		this.MinDeTiempo=minTiempo;
		this.Capacidad=capacidad;
		this.id=id;
		this.Propuestas= new ArrayList<>();
		if(tipo==ESTUDIANTE||tipo==EGRESADO||tipo==PADRE_DE_ESTUDIANTE
				   ||tipo==EMPLEADO||tipo==PROFESOR||tipo==PROFESOR_INVITADO)
				{
					this.Tipo=tipo;
				}
		
	}

	//Metodos get,set
	private String getNombre() {
		return this.Nombre;
	}


	private int getTipo() {
		return this.Tipo;
	}

	private double getMinDeTiempo() {
		return this.MinDeTiempo;
	}

	
	private double isCapacidad() {
		return this.Capacidad;
	}


	public List<Propuesta> getPropuestas() {
		if(this.Propuestas == null) {
				this.Propuestas = new ArrayList<>();
		}
		return this.Propuestas;
	}

	


	public long getId() {
		return this.id;
	}


	public void addAllPropuestas(Set<Propuesta> newPropuestas) {
		if (this.Propuestas == null) {
			this.Propuestas = new ArrayList<>();
		}
		for (Propuesta tmp : newPropuestas)
			tmp.setOperador(this);
		
	}

	

	
	public void removeAllPropuestas(Set<Propuesta> newPropuestas) {
		if(this.Propuestas == null) {
			return;
		}
		
		this.Propuestas.removeAll(newPropuestas);
	}





	private void setNombre(String myNombre) {
		this.Nombre = myNombre;
	}



	
	private void setMinDeTiempo(double myMinDeTiempo) {
		this.MinDeTiempo = myMinDeTiempo;
	}

	
	private void setCapacidad(double myCapacidad) {
		this.Capacidad = myCapacidad;
	}

	
	public void addPropuestas(Propuesta newPropuestas) {
		if(this.Propuestas == null) {
			this.Propuestas = new ArrayList<>();
		}
		
		if (this.Propuestas.add(newPropuestas))
			newPropuestas.basicSetOperador(this);
	}

	

	
	public void removePropuestas(Propuesta oldPropuestas) {
		if(this.Propuestas == null)
			return;
		
		if (this.Propuestas.remove(oldPropuestas))
			oldPropuestas.unsetOperador();
		
	}



}

