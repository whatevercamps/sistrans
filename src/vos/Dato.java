package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Dato {
	/**
	 * Nombre de este Sabor.
	 */
	@JsonProperty(value="name")
	private String name; 
	
	/**
	 * Atributo que contiene el valor de este Sabor.
	 */
	@JsonProperty(value="valor")
	private String valor; 
	
	
	/**
	 * Método constructor de la clase Sabor.
	 * @param id Long
	 * @param name String
	 */
	public Dato(@JsonProperty(value="name") String name, @JsonProperty(value="valor") String valor) {
		
		this.name = name;
		this.valor = valor;
	}

	/**
	 * Método que obtiene el nombre de este Sabor.
	 * @return String, nombre del Sabor.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método que establece el nombre de este Sabor.
	 * @param name String, nuevo nombre de este Sabor.
	 */
	public void setName(String name) {
		this.name = name; 
	}
	
	/**
	 * Método que obtiene el nombre de este Sabor.
	 * @return String, nombre del Sabor.
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * Método que establece el nombre de este Sabor.
	 * @param name String, nuevo nombre de este Sabor.
	 */
	public void setValor(String valor) {
		this.valor = valor; 
	}
}
