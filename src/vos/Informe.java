package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Informe {
	/**
	 * Atributo que contiene el ID del informe.
	 */
	@JsonProperty(value="id")
	private Long id; 
	/**
	 * Atributo que contiene el arreglo de valores que hacen parte del informe.
	 */
	@JsonProperty(value="datos")
	private List<Dato> datos; 
	
	
	/**
	 * M�todo constructor de la clase informe.
	 * @param id Long
	 * @param name String
	 */
	public Informe(@JsonProperty(value="id") Long id, @JsonProperty(value="datos") List<Dato> datos) {
		this.id = id;
		this.datos = datos;
	}
	public Informe(RentabilidadRestaurante a) {
		
	}
	/**
	 * M�todo que obtiene el ID del informe.
	 * @return Long, ID del informe.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * M�todo que establece el ID del informe.
	 * @param id Long, nuevo ID del informe.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * M�todo que obtiene el nombre del informe.
	 * @return String, nombre del informe.
	 */
	public List<Dato> getDatos() {
		return datos;
	}
	/**
	 * M�todo que establece el nombre del informe.
	 * @param name String, nuevo nombre del informe.
	 */
	public void setDatos(List<Dato> datos) {
		this.datos = datos; 
	}
}
